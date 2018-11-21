package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
}
