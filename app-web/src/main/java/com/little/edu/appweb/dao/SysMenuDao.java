package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {
	
}
