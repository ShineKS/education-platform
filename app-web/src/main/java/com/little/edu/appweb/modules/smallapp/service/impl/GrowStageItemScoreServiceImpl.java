package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.GrowStageItemScoreDao;
import com.little.edu.appweb.modules.smallapp.entity.GrowStageItemScoreEntity;
import com.little.edu.appweb.modules.smallapp.service.GrowStageItemScoreService;


@Service("growStageItemScoreService")
public class GrowStageItemScoreServiceImpl extends ServiceImpl<GrowStageItemScoreDao, GrowStageItemScoreEntity> implements GrowStageItemScoreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GrowStageItemScoreEntity> page = this.selectPage(
                new Query<GrowStageItemScoreEntity>(params).getPage(),
                new EntityWrapper<GrowStageItemScoreEntity>()
        );

        return new PageUtils(page);
    }

}
