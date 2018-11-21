package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.ScheduleJobLogEntity;
import com.little.edu.appweb.service.ScheduleJobLogService;
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
 * 定时任务日志
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@RestController
@RequestMapping("generator/schedulejoblog")
public class ScheduleJobLogController {
    @Autowired
    private ScheduleJobLogService scheduleJobLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:schedulejoblog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scheduleJobLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{logId}")
    @RequiresPermissions("generator:schedulejoblog:info")
    public R info(@PathVariable("logId") Long logId){
			ScheduleJobLogEntity scheduleJobLog = scheduleJobLogService.selectById(logId);

        return R.ok().put("scheduleJobLog", scheduleJobLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:schedulejoblog:save")
    public R save(@RequestBody ScheduleJobLogEntity scheduleJobLog){
			scheduleJobLogService.insert(scheduleJobLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:schedulejoblog:update")
    public R update(@RequestBody ScheduleJobLogEntity scheduleJobLog){
			scheduleJobLogService.updateById(scheduleJobLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:schedulejoblog:delete")
    public R delete(@RequestBody Long[] logIds){
			scheduleJobLogService.deleteBatchIds(Arrays.asList(logIds));

        return R.ok();
    }

}
