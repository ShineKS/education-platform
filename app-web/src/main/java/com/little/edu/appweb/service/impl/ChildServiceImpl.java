package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.ChildDao;
import com.little.edu.appweb.entity.ChildEntity;
import com.little.edu.appweb.service.ChildService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("childService")
public class ChildServiceImpl extends ServiceImpl<ChildDao, ChildEntity> implements ChildService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChildEntity> page = this.selectPage(
                new Query<ChildEntity>(params).getPage(),
                new EntityWrapper<ChildEntity>()
        );

        return new PageUtils(page);
    }

}
