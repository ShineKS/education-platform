package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.ScheduleJobDao;
import com.little.edu.appweb.entity.ScheduleJobEntity;
import com.little.edu.appweb.service.ScheduleJobService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("scheduleJobService")
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobDao, ScheduleJobEntity> implements ScheduleJobService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ScheduleJobEntity> page = this.selectPage(
                new Query<ScheduleJobEntity>(params).getPage(),
                new EntityWrapper<ScheduleJobEntity>()
        );

        return new PageUtils(page);
    }

}
