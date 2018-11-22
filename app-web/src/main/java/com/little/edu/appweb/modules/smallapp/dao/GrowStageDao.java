package com.little.edu.appweb.modules.smallapp.dao;

import com.little.edu.appweb.modules.smallapp.entity.GrowStageEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 记录每个成长日记的阶段内容
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@Mapper
public interface GrowStageDao extends BaseMapper<GrowStageEntity> {
	
}
