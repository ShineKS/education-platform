package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.AttachmentDao;
import com.little.edu.appweb.modules.smallapp.entity.AttachmentEntity;
import com.little.edu.appweb.modules.smallapp.service.AttachmentService;


@Service("attachmentService")
public class AttachmentServiceImpl extends ServiceImpl<AttachmentDao, AttachmentEntity> implements AttachmentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AttachmentEntity> page = this.selectPage(
                new Query<AttachmentEntity>(params).getPage(),
                new EntityWrapper<AttachmentEntity>()
        );

        return new PageUtils(page);
    }

}
