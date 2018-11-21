package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.SysRoleEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 角色
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

