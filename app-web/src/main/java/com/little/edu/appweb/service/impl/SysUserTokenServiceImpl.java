package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.SysUserTokenDao;
import com.little.edu.appweb.entity.SysUserTokenEntity;
import com.little.edu.appweb.service.SysUserTokenService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserTokenEntity> page = this.selectPage(
                new Query<SysUserTokenEntity>(params).getPage(),
                new EntityWrapper<SysUserTokenEntity>()
        );

        return new PageUtils(page);
    }

}
