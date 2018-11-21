package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzJobDetailsDao;
import com.little.edu.appweb.entity.QrtzJobDetailsEntity;
import com.little.edu.appweb.service.QrtzJobDetailsService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("qrtzJobDetailsService")
public class QrtzJobDetailsServiceImpl extends ServiceImpl<QrtzJobDetailsDao, QrtzJobDetailsEntity> implements QrtzJobDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzJobDetailsEntity> page = this.selectPage(
                new Query<QrtzJobDetailsEntity>(params).getPage(),
                new EntityWrapper<QrtzJobDetailsEntity>()
        );

        return new PageUtils(page);
    }

}
