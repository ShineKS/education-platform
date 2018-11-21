package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzCalendarsDao;
import com.little.edu.appweb.entity.QrtzCalendarsEntity;
import com.little.edu.appweb.service.QrtzCalendarsService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("qrtzCalendarsService")
public class QrtzCalendarsServiceImpl extends ServiceImpl<QrtzCalendarsDao, QrtzCalendarsEntity> implements QrtzCalendarsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzCalendarsEntity> page = this.selectPage(
                new Query<QrtzCalendarsEntity>(params).getPage(),
                new EntityWrapper<QrtzCalendarsEntity>()
        );

        return new PageUtils(page);
    }

}
