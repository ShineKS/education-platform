package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.ScheduleJobLogEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 定时任务日志
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
public interface ScheduleJobLogService extends IService<ScheduleJobLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

