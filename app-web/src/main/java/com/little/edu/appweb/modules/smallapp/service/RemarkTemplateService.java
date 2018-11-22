package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.RemarkTemplateEntity;

import java.util.Map;

/**
 * 阶段评价模板
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface RemarkTemplateService extends IService<RemarkTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

