package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.StageEvaluationDao;
import com.little.edu.appweb.modules.smallapp.entity.StageEvaluationEntity;
import com.little.edu.appweb.modules.smallapp.service.StageEvaluationService;


@Service("stageEvaluationService")
public class StageEvaluationServiceImpl extends ServiceImpl<StageEvaluationDao, StageEvaluationEntity> implements StageEvaluationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StageEvaluationEntity> page = this.selectPage(
                new Query<StageEvaluationEntity>(params).getPage(),
                new EntityWrapper<StageEvaluationEntity>()
        );

        return new PageUtils(page);
    }

}
