package com.little.edu.appweb.service;


import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.ChildEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 记录每一个孩子的实体
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
public interface ChildService extends IService<ChildEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

