package com.little.edu.appweb.modules.smallapp.service.impl;

import com.little.edu.appsdk.bean.WxMaJscode2SessionResult;
import com.little.edu.appsdk.service.WxMaService;
import com.little.edu.appweb.common.utils.R;
import com.little.edu.appweb.common.utils.RedisUtils;
import com.little.edu.appweb.modules.smallapp.reqBean.AppLogin;
import com.little.edu.appweb.modules.smallapp.service.SmallLoginService;
import com.little.edu.common.error.WxErrorException;
import com.little.edu.common.util.SessionUtil;
import com.little.edu.common.vaild.DataValidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmallLoginServiceImpl implements SmallLoginService {


    @Autowired
    private WxMaService wxMaService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public R appLogin(AppLogin req) {
        if (req == null) {
            return R.error("参数为空");
        }
        DataValidUtils.Result result = DataValidUtils.validation(req);
        if (!result.isSuc()) {
            return R.error(result.getMsg());
        }
        try {
            WxMaJscode2SessionResult data = wxMaService.jsCode2SessionInfo(req.getCode());
            // 放入redis
            String session = SessionUtil.genSession();
            redisUtils.set(session,data.getOpenid());
            return R.ok(session, "登录成功");
        } catch (WxErrorException e) {
            e.printStackTrace();
            return R.error(500, e.getMessage());
        }
    }
}
