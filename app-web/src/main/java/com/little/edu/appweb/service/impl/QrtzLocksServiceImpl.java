package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzLocksDao;
import com.little.edu.appweb.entity.QrtzLocksEntity;
import com.little.edu.appweb.service.QrtzLocksService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzLocksService")
public class QrtzLocksServiceImpl extends ServiceImpl<QrtzLocksDao, QrtzLocksEntity> implements QrtzLocksService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzLocksEntity> page = this.selectPage(
                new Query<QrtzLocksEntity>(params).getPage(),
                new EntityWrapper<QrtzLocksEntity>()
        );

        return new PageUtils(page);
    }

}
