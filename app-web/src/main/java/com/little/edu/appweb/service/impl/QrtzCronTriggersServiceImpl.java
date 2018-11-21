package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzCronTriggersDao;
import com.little.edu.appweb.entity.QrtzCronTriggersEntity;
import com.little.edu.appweb.service.QrtzCronTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzCronTriggersService")
public class QrtzCronTriggersServiceImpl extends ServiceImpl<QrtzCronTriggersDao, QrtzCronTriggersEntity> implements QrtzCronTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzCronTriggersEntity> page = this.selectPage(
                new Query<QrtzCronTriggersEntity>(params).getPage(),
                new EntityWrapper<QrtzCronTriggersEntity>()
        );

        return new PageUtils(page);
    }

}
