package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.QrtzCalendarsEntity;
import com.little.edu.appweb.service.QrtzCalendarsService;
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
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/qrtzcalendars")
public class QrtzCalendarsController {
    @Autowired
    private QrtzCalendarsService qrtzCalendarsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzcalendars:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzCalendarsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzcalendars:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzCalendarsEntity qrtzCalendars = qrtzCalendarsService.selectById(schedName);

        return R.ok().put("qrtzCalendars", qrtzCalendars);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzcalendars:save")
    public R save(@RequestBody QrtzCalendarsEntity qrtzCalendars){
			qrtzCalendarsService.insert(qrtzCalendars);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzcalendars:update")
    public R update(@RequestBody QrtzCalendarsEntity qrtzCalendars){
			qrtzCalendarsService.updateById(qrtzCalendars);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzcalendars:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzCalendarsService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
