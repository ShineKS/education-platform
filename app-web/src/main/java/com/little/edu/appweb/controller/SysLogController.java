package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.SysLogEntity;
import com.little.edu.appweb.service.SysLogService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统日志
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:syslog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:syslog:info")
    public R info(@PathVariable("id") Long id){
			SysLogEntity sysLog = sysLogService.selectById(id);

        return R.ok().put("sysLog", sysLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:syslog:save")
    public R save(@RequestBody SysLogEntity sysLog){
			sysLogService.insert(sysLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:syslog:update")
    public R update(@RequestBody SysLogEntity sysLog){
			sysLogService.updateById(sysLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:syslog:delete")
    public R delete(@RequestBody Long[] ids){
			sysLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
