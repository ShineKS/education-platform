package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.StudentDao;
import com.little.edu.appweb.modules.smallapp.entity.StudentEntity;
import com.little.edu.appweb.modules.smallapp.service.StudentService;


@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StudentEntity> page = this.selectPage(
                new Query<StudentEntity>(params).getPage(),
                new EntityWrapper<StudentEntity>()
        );

        return new PageUtils(page);
    }

}
