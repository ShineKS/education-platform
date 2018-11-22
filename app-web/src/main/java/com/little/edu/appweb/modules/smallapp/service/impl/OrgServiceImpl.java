package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.OrgDao;
import com.little.edu.appweb.modules.smallapp.entity.OrgEntity;
import com.little.edu.appweb.modules.smallapp.service.OrgService;


@Service("orgService")
public class OrgServiceImpl extends ServiceImpl<OrgDao, OrgEntity> implements OrgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrgEntity> page = this.selectPage(
                new Query<OrgEntity>(params).getPage(),
                new EntityWrapper<OrgEntity>()
        );

        return new PageUtils(page);
    }

}
