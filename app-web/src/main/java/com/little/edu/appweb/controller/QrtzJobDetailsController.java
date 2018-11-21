package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.QrtzJobDetailsEntity;
import com.little.edu.appweb.service.QrtzJobDetailsService;
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
@RequestMapping("generator/qrtzjobdetails")
public class QrtzJobDetailsController {
    @Autowired
    private QrtzJobDetailsService qrtzJobDetailsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:qrtzjobdetails:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = qrtzJobDetailsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{schedName}")
    @RequiresPermissions("generator:qrtzjobdetails:info")
    public R info(@PathVariable("schedName") String schedName){
			QrtzJobDetailsEntity qrtzJobDetails = qrtzJobDetailsService.selectById(schedName);

        return R.ok().put("qrtzJobDetails", qrtzJobDetails);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:qrtzjobdetails:save")
    public R save(@RequestBody QrtzJobDetailsEntity qrtzJobDetails){
			qrtzJobDetailsService.insert(qrtzJobDetails);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:qrtzjobdetails:update")
    public R update(@RequestBody QrtzJobDetailsEntity qrtzJobDetails){
			qrtzJobDetailsService.updateById(qrtzJobDetails);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:qrtzjobdetails:delete")
    public R delete(@RequestBody String[] schedNames){
			qrtzJobDetailsService.deleteBatchIds(Arrays.asList(schedNames));

        return R.ok();
    }

}
