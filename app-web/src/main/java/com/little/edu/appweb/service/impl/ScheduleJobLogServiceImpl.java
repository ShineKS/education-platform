package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.ScheduleJobLogDao;
import com.little.edu.appweb.entity.ScheduleJobLogEntity;
import com.little.edu.appweb.service.ScheduleJobLogService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLogEntity> implements ScheduleJobLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ScheduleJobLogEntity> page = this.selectPage(
                new Query<ScheduleJobLogEntity>(params).getPage(),
                new EntityWrapper<ScheduleJobLogEntity>()
        );

        return new PageUtils(page);
    }

}
