package com.little.edu.appweb.service;


import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.GrowStageItemScoreEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 成长之路报告表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
public interface GrowStageItemScoreService extends IService<GrowStageItemScoreEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

