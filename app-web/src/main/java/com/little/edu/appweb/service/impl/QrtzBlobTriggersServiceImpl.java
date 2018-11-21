package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.QrtzBlobTriggersDao;
import com.little.edu.appweb.entity.QrtzBlobTriggersEntity;
import com.little.edu.appweb.service.QrtzBlobTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("qrtzBlobTriggersService")
public class QrtzBlobTriggersServiceImpl extends ServiceImpl<QrtzBlobTriggersDao, QrtzBlobTriggersEntity> implements QrtzBlobTriggersService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QrtzBlobTriggersEntity> page = this.selectPage(
                new Query<QrtzBlobTriggersEntity>(params).getPage(),
                new EntityWrapper<QrtzBlobTriggersEntity>()
        );

        return new PageUtils(page);
    }

}
