package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.GrowDiaryDao;
import com.little.edu.appweb.entity.GrowDiaryEntity;
import com.little.edu.appweb.service.GrowDiaryService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("growDiaryService")
public class GrowDiaryServiceImpl extends ServiceImpl<GrowDiaryDao, GrowDiaryEntity> implements GrowDiaryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GrowDiaryEntity> page = this.selectPage(
                new Query<GrowDiaryEntity>(params).getPage(),
                new EntityWrapper<GrowDiaryEntity>()
        );

        return new PageUtils(page);
    }

}
