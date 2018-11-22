package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.GuarderDao;
import com.little.edu.appweb.modules.smallapp.entity.GuarderEntity;
import com.little.edu.appweb.modules.smallapp.service.GuarderService;


@Service("guarderService")
public class GuarderServiceImpl extends ServiceImpl<GuarderDao, GuarderEntity> implements GuarderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GuarderEntity> page = this.selectPage(
                new Query<GuarderEntity>(params).getPage(),
                new EntityWrapper<GuarderEntity>()
        );

        return new PageUtils(page);
    }

}
