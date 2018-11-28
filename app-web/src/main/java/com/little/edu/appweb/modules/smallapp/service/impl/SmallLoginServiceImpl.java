package com.little.edu.appweb.modules.smallapp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.little.edu.appsdk.bean.WxMaJscode2SessionResult;
import com.little.edu.appsdk.bean.WxMaUserInfo;
import com.little.edu.appsdk.service.WxMaService;
import com.little.edu.appsdk.service.WxMaUserService;
import com.little.edu.appweb.common.constant.RedisKey;
import com.little.edu.appweb.common.utils.HttpContextUtils;
import com.little.edu.appweb.common.utils.R;
import com.little.edu.appweb.common.utils.RedisUtils;
import com.little.edu.appweb.modules.smallapp.entity.WeixinUserEntity;
import com.little.edu.appweb.modules.smallapp.reqBean.AppLogin;
import com.little.edu.appweb.modules.smallapp.service.SmallLoginService;
import com.little.edu.appweb.modules.smallapp.service.WeixinUserService;
import com.little.edu.common.error.WxErrorException;
import com.little.edu.common.util.BeanUtils;
import com.little.edu.common.util.SessionUtil;
import com.little.edu.common.vaild.DataValidUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class SmallLoginServiceImpl implements SmallLoginService {


    @Autowired
    private WxMaService wxMaService;
    @Autowired
    private WxMaUserService wxMaUserService;
    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private WeixinUserService weixinUserService;
    @Override
    public R appLogin(HttpServletRequest request, AppLogin req) {
        //如果登录状态没有过期,则刷新时间,默认8小时
        String session = HttpContextUtils.getHeaderParam("session", request);
        String openid = redisUtils.get(RedisKey.SESSION + session);
        if (!StringUtils.isEmpty(openid)) {
            redisUtils.set(RedisKey.SESSION + session, openid, 28800);
            return R.ok(session, "登录成功");
        }
        if (req == null) {
            return R.error("参数为空");
        }
        DataValidUtils.Result result = DataValidUtils.validation(req);
        if (!result.isSuc()) {
            return R.error(result.getMsg());
        }
        try {
            WxMaJscode2SessionResult data = wxMaService.jsCode2SessionInfo(req.getCode());
            // 存入redis
            session = SessionUtil.genSession();
            redisUtils.set(RedisKey.SESSION + session, data.getOpenid(), 28800);
            //更新或插入粉丝表
            WxMaUserInfo userInfo = wxMaUserService.getUserInfo(data.getSessionKey(), req.getEncryptedData(), req.getIv());
            if (userInfo != null) {
                WeixinUserEntity user = new WeixinUserEntity();
                BeanUtil.copyProperties(userInfo, user);
                weixinUserService.insertOrupdateFuns(user);
            }
            return R.ok(session, "登录成功");
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.error("登录异常{}",e.getMessage());
            return R.error(500, e.getMessage());
        }
    }


}
