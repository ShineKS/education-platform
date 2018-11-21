package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.GrowStageItemScoreDao;
import com.little.edu.appweb.entity.GrowStageItemScoreEntity;
import com.little.edu.appweb.service.GrowStageItemScoreService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

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
