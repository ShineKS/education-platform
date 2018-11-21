package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzPausedTriggerGrpsDao;
import com.little.edu.appweb.entity.QrtzPausedTriggerGrpsEntity;
import com.little.edu.appweb.service.QrtzPausedTriggerGrpsService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzPausedTriggerGrpsService")
public class QrtzPausedTriggerGrpsServiceImpl extends ServiceImpl<QrtzPausedTriggerGrpsDao, QrtzPausedTriggerGrpsEntity> implements QrtzPausedTriggerGrpsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzPausedTriggerGrpsEntity> page = this.selectPage(
                new Query<QrtzPausedTriggerGrpsEntity>(params).getPage(),
                new EntityWrapper<QrtzPausedTriggerGrpsEntity>()
        );

        return new PageUtils(page);
    }

}
