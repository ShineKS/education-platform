package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.QrtzTriggersEntity;
import com.little.edu.appweb.service.QrtzTriggersService;
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
@RequestMapping("generator/qrtztriggers")
public class QrtzTriggersController {
    @Autowired
    private QrtzTriggersService qrtzTriggersService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtztriggers:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzTriggersService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtztriggers:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzTriggersEntity qrtzTriggers = qrtzTriggersService.selectById(schedName);

        return R.ok().put("qrtzTriggers", qrtzTriggers);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtztriggers:save")
    public R save(@RequestBody QrtzTriggersEntity qrtzTriggers){
			qrtzTriggersService.insert(qrtzTriggers);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtztriggers:update")
    public R update(@RequestBody QrtzTriggersEntity qrtzTriggers){
			qrtzTriggersService.updateById(qrtzTriggers);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtztriggers:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzTriggersService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
