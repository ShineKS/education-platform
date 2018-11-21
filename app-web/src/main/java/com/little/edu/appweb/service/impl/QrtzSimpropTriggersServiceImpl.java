package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzSimpropTriggersDao;
import com.little.edu.appweb.entity.QrtzSimpropTriggersEntity;
import com.little.edu.appweb.service.QrtzSimpropTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzSimpropTriggersService")
public class QrtzSimpropTriggersServiceImpl extends ServiceImpl<QrtzSimpropTriggersDao, QrtzSimpropTriggersEntity> implements QrtzSimpropTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzSimpropTriggersEntity> page = this.selectPage(
                new Query<QrtzSimpropTriggersEntity>(params).getPage(),
                new EntityWrapper<QrtzSimpropTriggersEntity>()
        );

        return new PageUtils(page);
    }

}
