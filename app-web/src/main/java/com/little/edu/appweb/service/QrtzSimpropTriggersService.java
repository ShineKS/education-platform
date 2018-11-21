package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.QrtzSimpropTriggersEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
public interface QrtzSimpropTriggersService extends IService<QrtzSimpropTriggersEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

