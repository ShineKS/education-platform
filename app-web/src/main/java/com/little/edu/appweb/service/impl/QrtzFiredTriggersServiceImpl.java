package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzFiredTriggersDao;
import com.little.edu.appweb.entity.QrtzFiredTriggersEntity;
import com.little.edu.appweb.service.QrtzFiredTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzFiredTriggersService")
public class QrtzFiredTriggersServiceImpl extends ServiceImpl<QrtzFiredTriggersDao, QrtzFiredTriggersEntity> implements QrtzFiredTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzFiredTriggersEntity> page = this.selectPage(
                new Query<QrtzFiredTriggersEntity>(params).getPage(),
                new EntityWrapper<QrtzFiredTriggersEntity>()
        );

        return new PageUtils(page);
    }

}
