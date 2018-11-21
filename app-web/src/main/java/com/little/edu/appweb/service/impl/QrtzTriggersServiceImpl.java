package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzTriggersDao;
import com.little.edu.appweb.entity.QrtzTriggersEntity;
import com.little.edu.appweb.service.QrtzTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("qrtzTriggersService")
public class QrtzTriggersServiceImpl extends ServiceImpl<QrtzTriggersDao, QrtzTriggersEntity> implements QrtzTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzTriggersEntity> page = this.selectPage(
                new Query<QrtzTriggersEntity>(params).getPage(),
                new EntityWrapper<QrtzTriggersEntity>()
        );

        return new PageUtils(page);
    }

}
