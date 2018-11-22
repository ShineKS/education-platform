package com.little.edu.appweb.modules.smallapp.dao;

import com.little.edu.appweb.modules.smallapp.entity.StudentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学员表
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}
