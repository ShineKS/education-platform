package com.little.edu.appweb.modules.smallapp.dao;

import com.little.edu.appweb.modules.smallapp.entity.StageEvaluationEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 家长对于每个日记每个阶段的成长之路评价
 * 
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@Mapper
public interface StageEvaluationDao extends BaseMapper<StageEvaluationEntity> {
	
}
