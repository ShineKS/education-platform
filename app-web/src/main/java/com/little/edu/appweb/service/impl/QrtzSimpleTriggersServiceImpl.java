package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzSimpleTriggersDao;
import com.little.edu.appweb.entity.QrtzSimpleTriggersEntity;
import com.little.edu.appweb.service.QrtzSimpleTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzSimpleTriggersService")
public class QrtzSimpleTriggersServiceImpl extends ServiceImpl<QrtzSimpleTriggersDao, QrtzSimpleTriggersEntity> implements QrtzSimpleTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzSimpleTriggersEntity> page = this.selectPage(
                new Query<QrtzSimpleTriggersEntity>(params).getPage(),
                new EntityWrapper<QrtzSimpleTriggersEntity>()
        );

        return new PageUtils(page);
    }

}
