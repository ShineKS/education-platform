package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.SysMenuDao;
import com.little.edu.appweb.entity.SysMenuEntity;
import com.little.edu.appweb.service.SysMenuService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysMenuEntity> page = this.selectPage(
                new Query<SysMenuEntity>(params).getPage(),
                new EntityWrapper<SysMenuEntity>()
        );

        return new PageUtils(page);
    }

}
