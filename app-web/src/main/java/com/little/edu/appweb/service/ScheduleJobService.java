package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.ScheduleJobEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
public interface ScheduleJobService extends IService<ScheduleJobEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

