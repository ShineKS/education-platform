package com.little.edu.appweb.modules.smallapp.service.impl;

import com.little.edu.appweb.common.utils.R;
import jodd.util.CollectionUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.WeixinUserDao;
import com.little.edu.appweb.modules.smallapp.entity.WeixinUserEntity;
import com.little.edu.appweb.modules.smallapp.service.WeixinUserService;


@Service("weixinUserService")
public class WeixinUserServiceImpl extends ServiceImpl<WeixinUserDao, WeixinUserEntity> implements WeixinUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixinUserEntity> page = this.selectPage(
                new Query<WeixinUserEntity>(params).getPage(),
                new EntityWrapper<WeixinUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public R insertOrupdateFuns(WeixinUserEntity userEntity) {
        if(userEntity==null||StringUtils.isEmpty(userEntity.getOpenId())){
            return R.error("参数为空");
        }
        EntityWrapper<WeixinUserEntity> wp = new EntityWrapper<>();
        wp.eq("open_id", userEntity.getOpenId());
        List<WeixinUserEntity> list = this.baseMapper.selectList(wp);
        if (CollectionUtils.isEmpty(list)) {
            userEntity.setCreateDate(new Date());
            baseMapper.insert(userEntity);
        }else{
            userEntity.setId(list.get(0).getId());
            baseMapper.updateById(userEntity);
        }
        return R.ok("操作成功");
    }

}
