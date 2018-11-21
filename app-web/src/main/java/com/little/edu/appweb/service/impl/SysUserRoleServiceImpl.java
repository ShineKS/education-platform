package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.SysUserRoleDao;
import com.little.edu.appweb.entity.SysUserRoleEntity;
import com.little.edu.appweb.service.SysUserRoleService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysUserRoleEntity> page = this.selectPage(
                new Query<SysUserRoleEntity>(params).getPage(),
                new EntityWrapper<SysUserRoleEntity>()
        );

        return new PageUtils(page);
    }

}
