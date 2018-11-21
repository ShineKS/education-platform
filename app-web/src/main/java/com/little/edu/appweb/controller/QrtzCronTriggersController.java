package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.QrtzCronTriggersEntity;
import com.little.edu.appweb.service.QrtzCronTriggersService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@RestController
@RequestMapping("generator/qrtzcrontriggers")
public class QrtzCronTriggersController {
    @Autowired
    private QrtzCronTriggersService qrtzCronTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzcrontriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzCronTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzcrontriggers:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzCronTriggersEntity qrtzCronTriggers = qrtzCronTriggersService.selectById(schedName);

        return R.ok().put("qrtzCronTriggers", qrtzCronTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzcrontriggers:save")
    public R save(@RequestBody QrtzCronTriggersEntity qrtzCronTriggers){
			qrtzCronTriggersService.insert(qrtzCronTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzcrontriggers:update")
    public R update(@RequestBody QrtzCronTriggersEntity qrtzCronTriggers){
			qrtzCronTriggersService.updateById(qrtzCronTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzcrontriggers:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzCronTriggersService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
