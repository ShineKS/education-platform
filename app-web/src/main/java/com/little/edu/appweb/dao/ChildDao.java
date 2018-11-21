package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.ChildEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 记录每一个孩子的实体
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@Mapper
public interface ChildDao extends BaseMapper<ChildEntity> {
	
}
