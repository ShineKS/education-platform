package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.GrowStageDao;
import com.little.edu.appweb.entity.GrowStageEntity;
import com.little.edu.appweb.service.GrowStageService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

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
