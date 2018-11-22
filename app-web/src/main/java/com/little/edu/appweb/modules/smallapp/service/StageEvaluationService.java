package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.StageEvaluationEntity;

import java.util.Map;

/**
 * 家长对于每个日记每个阶段的成长之路评价
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface StageEvaluationService extends IService<StageEvaluationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

