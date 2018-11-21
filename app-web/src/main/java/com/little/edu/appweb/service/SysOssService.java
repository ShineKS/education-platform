package com.little.edu.appweb.service;

import com.baomidou.mybatisplus.service.IService;
import com.little.edu.appweb.entity.SysOssEntity;
import com.little.edu.appweb.utils.PageUtils;

import java.util.Map;

/**
 * 文件上传
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
public interface SysOssService extends IService<SysOssEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

