package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
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

}
