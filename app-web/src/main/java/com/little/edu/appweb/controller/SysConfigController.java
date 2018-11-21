package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.SysConfigEntity;
import com.little.edu.appweb.service.SysConfigService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@RestController
@RequestMapping("generator/sysconfig")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysconfig:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysConfigService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:sysconfig:info")
    public R info(@PathVariable("id") Long id){
			SysConfigEntity sysConfig = sysConfigService.selectById(id);

        return R.ok().put("sysConfig", sysConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysconfig:save")
    public R save(@RequestBody SysConfigEntity sysConfig){
			sysConfigService.insert(sysConfig);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysconfig:update")
    public R update(@RequestBody SysConfigEntity sysConfig){
			sysConfigService.updateById(sysConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysconfig:delete")
    public R delete(@RequestBody Long[] ids){
			sysConfigService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
