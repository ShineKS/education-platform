package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.ClassInfoDao;
import com.little.edu.appweb.modules.smallapp.entity.ClassInfoEntity;
import com.little.edu.appweb.modules.smallapp.service.ClassInfoService;


@Service("classInfoService")
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoDao, ClassInfoEntity> implements ClassInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClassInfoEntity> page = this.selectPage(
                new Query<ClassInfoEntity>(params).getPage(),
                new EntityWrapper<ClassInfoEntity>()
        );

        return new PageUtils(page);
    }

}
