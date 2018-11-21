package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.SysMenuEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 菜单管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

