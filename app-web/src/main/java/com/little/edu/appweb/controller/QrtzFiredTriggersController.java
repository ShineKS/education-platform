package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.QrtzFiredTriggersEntity;
import com.little.edu.appweb.service.QrtzFiredTriggersService;
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
@RequestMapping("generator/qrtzfiredtriggers")
public class QrtzFiredTriggersController {
    @Autowired
    private QrtzFiredTriggersService qrtzFiredTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzfiredtriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzFiredTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzfiredtriggers:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzFiredTriggersEntity qrtzFiredTriggers = qrtzFiredTriggersService.selectById(schedName);

        return R.ok().put("qrtzFiredTriggers", qrtzFiredTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzfiredtriggers:save")
    public R save(@RequestBody QrtzFiredTriggersEntity qrtzFiredTriggers){
			qrtzFiredTriggersService.insert(qrtzFiredTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzfiredtriggers:update")
    public R update(@RequestBody QrtzFiredTriggersEntity qrtzFiredTriggers){
			qrtzFiredTriggersService.updateById(qrtzFiredTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzfiredtriggers:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzFiredTriggersService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
