package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.GrowDiaryEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 成长日记日记表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@Mapper
public interface GrowDiaryDao extends BaseMapper<GrowDiaryEntity> {
	
}
