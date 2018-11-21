package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.ScheduleJobEntity;
import com.little.edu.appweb.service.ScheduleJobService;
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
 * 定时任务
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@RestController
@RequestMapping("generator/schedulejob")
public class ScheduleJobController {
    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:schedulejob:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = scheduleJobService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{jobId}")
    @RequiresPermissions("generator:schedulejob:info")
    public R info(@PathVariable("jobId") Long jobId){
			ScheduleJobEntity scheduleJob = scheduleJobService.selectById(jobId);

        return R.ok().put("scheduleJob", scheduleJob);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:schedulejob:save")
    public R save(@RequestBody ScheduleJobEntity scheduleJob){
			scheduleJobService.insert(scheduleJob);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:schedulejob:update")
    public R update(@RequestBody ScheduleJobEntity scheduleJob){
			scheduleJobService.updateById(scheduleJob);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:schedulejob:delete")
    public R delete(@RequestBody Long[] jobIds){
			scheduleJobService.deleteBatchIds(Arrays.asList(jobIds));

        return R.ok();
    }

}
