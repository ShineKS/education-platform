package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.CourseLibaryEntity;

import java.util.Map;

/**
 * 课程库表,记录机构的所有课程
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface CourseLibaryService extends IService<CourseLibaryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

