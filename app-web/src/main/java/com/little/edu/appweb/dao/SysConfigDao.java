package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.SysConfigEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统配置信息表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@Mapper
public interface SysConfigDao extends BaseMapper<SysConfigEntity> {
	
}
