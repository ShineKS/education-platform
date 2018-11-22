package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.AttachRelationDao;
import com.little.edu.appweb.modules.smallapp.entity.AttachRelationEntity;
import com.little.edu.appweb.modules.smallapp.service.AttachRelationService;


@Service("attachRelationService")
public class AttachRelationServiceImpl extends ServiceImpl<AttachRelationDao, AttachRelationEntity> implements AttachRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AttachRelationEntity> page = this.selectPage(
                new Query<AttachRelationEntity>(params).getPage(),
                new EntityWrapper<AttachRelationEntity>()
        );

        return new PageUtils(page);
    }

}
