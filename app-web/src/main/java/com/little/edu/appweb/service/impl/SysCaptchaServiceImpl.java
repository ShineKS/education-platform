package com.little.edu.appweb.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.little.edu.appweb.dao.SysCaptchaDao;
import com.little.edu.appweb.entity.SysCaptchaEntity;
import com.little.edu.appweb.service.SysCaptchaService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.Query;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysCaptchaEntity> page = this.selectPage(
                new Query<SysCaptchaEntity>(params).getPage(),
                new EntityWrapper<SysCaptchaEntity>()
        );

        return new PageUtils(page);
    }

}
