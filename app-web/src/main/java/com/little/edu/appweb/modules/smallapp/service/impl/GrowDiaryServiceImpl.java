package com.little.edu.appweb.modules.smallapp.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.Query;

import com.little.edu.appweb.modules.smallapp.dao.GrowDiaryDao;
import com.little.edu.appweb.modules.smallapp.entity.GrowDiaryEntity;
import com.little.edu.appweb.modules.smallapp.service.GrowDiaryService;


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
