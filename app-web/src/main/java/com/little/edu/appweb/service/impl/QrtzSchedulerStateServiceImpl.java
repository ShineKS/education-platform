package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzSchedulerStateDao;
import com.little.edu.appweb.entity.QrtzSchedulerStateEntity;
import com.little.edu.appweb.service.QrtzSchedulerStateService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzSchedulerStateService")
public class QrtzSchedulerStateServiceImpl extends ServiceImpl<QrtzSchedulerStateDao, QrtzSchedulerStateEntity> implements QrtzSchedulerStateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzSchedulerStateEntity> page = this.selectPage(
                new Query<QrtzSchedulerStateEntity>(params).getPage(),
                new EntityWrapper<QrtzSchedulerStateEntity>()
        );

        return new PageUtils(page);
    }

}
