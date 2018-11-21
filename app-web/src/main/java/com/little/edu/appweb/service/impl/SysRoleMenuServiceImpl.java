package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.SysRoleMenuDao;
import com.little.edu.appweb.entity.SysRoleMenuEntity;
import com.little.edu.appweb.service.SysRoleMenuService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysRoleMenuEntity> page = this.selectPage(
                new Query<SysRoleMenuEntity>(params).getPage(),
                new EntityWrapper<SysRoleMenuEntity>()
        );

        return new PageUtils(page);
    }

}
