package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.QrtzSchedulerStateEntity;
import com.little.edu.appweb.service.QrtzSchedulerStateService;
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
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@RestController
@RequestMapping("generator/qrtzschedulerstate")
public class QrtzSchedulerStateController {
    @Autowired
    private QrtzSchedulerStateService qrtzSchedulerStateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzschedulerstate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzSchedulerStateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzschedulerstate:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzSchedulerStateEntity qrtzSchedulerState = qrtzSchedulerStateService.selectById(schedName);

        return R.ok().put("qrtzSchedulerState", qrtzSchedulerState);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzschedulerstate:save")
    public R save(@RequestBody QrtzSchedulerStateEntity qrtzSchedulerState){
			qrtzSchedulerStateService.insert(qrtzSchedulerState);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzschedulerstate:update")
    public R update(@RequestBody QrtzSchedulerStateEntity qrtzSchedulerState){
			qrtzSchedulerStateService.updateById(qrtzSchedulerState);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzschedulerstate:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzSchedulerStateService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
