package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.GrowStageEntity;

import java.util.Map;

/**
 * 记录每个成长日记的阶段内容
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface GrowStageService extends IService<GrowStageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

