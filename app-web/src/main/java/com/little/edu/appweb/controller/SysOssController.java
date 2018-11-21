package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.SysOssEntity;
import com.little.edu.appweb.service.SysOssService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 文件上传
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@RestController
@RequestMapping("generator/sysoss")
public class SysOssController {
    @Autowired
    private SysOssService sysOssService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysoss:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysOssService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:sysoss:info")
    public R info(@PathVariable("id") Long id){
			SysOssEntity sysOss = sysOssService.selectById(id);

        return R.ok().put("sysOss", sysOss);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysoss:save")
    public R save(@RequestBody SysOssEntity sysOss){
			sysOssService.insert(sysOss);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysoss:update")
    public R update(@RequestBody SysOssEntity sysOss){
			sysOssService.updateById(sysOss);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysoss:delete")
    public R delete(@RequestBody Long[] ids){
			sysOssService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
