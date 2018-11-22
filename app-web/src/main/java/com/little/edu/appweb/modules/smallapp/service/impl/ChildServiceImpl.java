package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.ChildDao;
import com.little.edu.appweb.modules.smallapp.entity.ChildEntity;
import com.little.edu.appweb.modules.smallapp.service.ChildService;


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
