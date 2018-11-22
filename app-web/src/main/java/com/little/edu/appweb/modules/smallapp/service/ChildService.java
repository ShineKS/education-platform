package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.ChildEntity;

import java.util.Map;

/**
 * 记录每一个孩子的实体
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface ChildService extends IService<ChildEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

