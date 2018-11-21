package com.little.edu.appweb.service;


import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.GrowStageEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 记录每个成长日记的阶段内容
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
public interface GrowStageService extends IService<GrowStageEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

