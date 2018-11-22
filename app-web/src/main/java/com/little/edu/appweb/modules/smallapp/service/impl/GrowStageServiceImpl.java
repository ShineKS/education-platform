package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.GrowStageDao;
import com.little.edu.appweb.modules.smallapp.entity.GrowStageEntity;
import com.little.edu.appweb.modules.smallapp.service.GrowStageService;


@Service("growStageService")
public class GrowStageServiceImpl extends ServiceImpl<GrowStageDao, GrowStageEntity> implements GrowStageService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GrowStageEntity> page = this.selectPage(
                new Query<GrowStageEntity>(params).getPage(),
                new EntityWrapper<GrowStageEntity>()
        );

        return new PageUtils(page);
    }

}
