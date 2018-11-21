package com.little.edu.appweb.service;


import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.GrowDiaryEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 成长日记日记表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
public interface GrowDiaryService extends IService<GrowDiaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

