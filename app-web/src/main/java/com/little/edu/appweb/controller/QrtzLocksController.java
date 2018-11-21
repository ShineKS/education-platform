package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.QrtzLocksEntity;
import com.little.edu.appweb.service.QrtzLocksService;
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
@RequestMapping("generator/qrtzlocks")
public class QrtzLocksController {
    @Autowired
    private QrtzLocksService qrtzLocksService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzlocks:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzLocksService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzlocks:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzLocksEntity qrtzLocks = qrtzLocksService.selectById(schedName);

        return R.ok().put("qrtzLocks", qrtzLocks);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzlocks:save")
    public R save(@RequestBody QrtzLocksEntity qrtzLocks){
			qrtzLocksService.insert(qrtzLocks);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzlocks:update")
    public R update(@RequestBody QrtzLocksEntity qrtzLocks){
			qrtzLocksService.updateById(qrtzLocks);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzlocks:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzLocksService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
