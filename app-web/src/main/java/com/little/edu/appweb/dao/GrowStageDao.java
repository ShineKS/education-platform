package com.little.edu.appweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.little.edu.appweb.entity.GrowStageEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 记录每个成长日记的阶段内容
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@Mapper
public interface GrowStageDao extends BaseMapper<GrowStageEntity> {
	
}
