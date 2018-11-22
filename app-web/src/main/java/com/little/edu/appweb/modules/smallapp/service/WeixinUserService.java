package com.little.edu.appweb.modules.smallapp.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.modules.smallapp.entity.WeixinUserEntity;

import java.util.Map;

/**
 * 用于记录所有微信访问的用户
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
public interface WeixinUserService extends IService<WeixinUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

