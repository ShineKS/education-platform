package com.little.edu.appweb.modules.smallapp.dao;

import com.little.edu.appweb.modules.smallapp.entity.CourseLibaryEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程库表,记录机构的所有课程
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@Mapper
public interface CourseLibaryDao extends BaseMapper<CourseLibaryEntity> {
	
}
