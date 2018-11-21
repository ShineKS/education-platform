package com.little.edu.appweb.service;


import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.QrtzCalendarsEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
public interface QrtzCalendarsService extends IService<QrtzCalendarsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

