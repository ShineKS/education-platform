package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.RemarkTemplateDao;
import com.little.edu.appweb.modules.smallapp.entity.RemarkTemplateEntity;
import com.little.edu.appweb.modules.smallapp.service.RemarkTemplateService;


@Service("remarkTemplateService")
public class RemarkTemplateServiceImpl extends ServiceImpl<RemarkTemplateDao, RemarkTemplateEntity> implements RemarkTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RemarkTemplateEntity> page = this.selectPage(
                new Query<RemarkTemplateEntity>(params).getPage(),
                new EntityWrapper<RemarkTemplateEntity>()
        );

        return new PageUtils(page);
    }

}
