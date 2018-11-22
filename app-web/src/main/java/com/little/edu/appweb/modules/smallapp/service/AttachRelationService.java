package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.AttachRelationEntity;

import java.util.Map;

/**
 * 附件资源关系表
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface AttachRelationService extends IService<AttachRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

