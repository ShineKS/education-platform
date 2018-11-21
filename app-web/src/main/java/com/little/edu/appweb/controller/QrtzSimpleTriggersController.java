package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.QrtzSimpleTriggersEntity;
import com.little.edu.appweb.service.QrtzSimpleTriggersService;
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
@RequestMapping("generator/qrtzsimpletriggers")
public class QrtzSimpleTriggersController {
    @Autowired
    private QrtzSimpleTriggersService qrtzSimpleTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzsimpletriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzSimpleTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzsimpletriggers:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzSimpleTriggersEntity qrtzSimpleTriggers = qrtzSimpleTriggersService.selectById(schedName);

        return R.ok().put("qrtzSimpleTriggers", qrtzSimpleTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzsimpletriggers:save")
    public R save(@RequestBody QrtzSimpleTriggersEntity qrtzSimpleTriggers){
			qrtzSimpleTriggersService.insert(qrtzSimpleTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzsimpletriggers:update")
    public R update(@RequestBody QrtzSimpleTriggersEntity qrtzSimpleTriggers){
			qrtzSimpleTriggersService.updateById(qrtzSimpleTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzsimpletriggers:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzSimpleTriggersService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
