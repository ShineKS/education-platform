package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.CourseLibaryDao;
import com.little.edu.appweb.modules.smallapp.entity.CourseLibaryEntity;
import com.little.edu.appweb.modules.smallapp.service.CourseLibaryService;


@Service("courseLibaryService")
public class CourseLibaryServiceImpl extends ServiceImpl<CourseLibaryDao, CourseLibaryEntity> implements CourseLibaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CourseLibaryEntity> page = this.selectPage(
                new Query<CourseLibaryEntity>(params).getPage(),
                new EntityWrapper<CourseLibaryEntity>()
        );

        return new PageUtils(page);
    }

}
