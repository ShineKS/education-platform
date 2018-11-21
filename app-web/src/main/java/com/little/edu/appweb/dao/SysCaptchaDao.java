package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统验证码
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {
	
}
