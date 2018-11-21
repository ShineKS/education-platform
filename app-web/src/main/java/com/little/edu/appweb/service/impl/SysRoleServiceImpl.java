package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.SysRoleDao;
import com.little.edu.appweb.entity.SysRoleEntity;
import com.little.edu.appweb.service.SysRoleService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements SysRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleEntity> page = this.selectPage(
                new Query<SysRoleEntity>(params).getPage(),
                new EntityWrapper<SysRoleEntity>()
        );

        return new PageUtils(page);
    }

}
