package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.SysUserRoleEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

