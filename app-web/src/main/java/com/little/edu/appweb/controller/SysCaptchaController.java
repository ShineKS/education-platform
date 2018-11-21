package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.SysCaptchaEntity;
import com.little.edu.appweb.service.SysCaptchaService;
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
 * 系统验证码
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/syscaptcha")
public class SysCaptchaController {
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:syscaptcha:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCaptchaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uuid}")
    @RequiresPermissions("generator:syscaptcha:info")
    public R info(@PathVariable("uuid") String uuid){
			SysCaptchaEntity sysCaptcha = sysCaptchaService.selectById(uuid);

        return R.ok().put("sysCaptcha", sysCaptcha);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:syscaptcha:save")
    public R save(@RequestBody SysCaptchaEntity sysCaptcha){
			sysCaptchaService.insert(sysCaptcha);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:syscaptcha:update")
    public R update(@RequestBody SysCaptchaEntity sysCaptcha){
			sysCaptchaService.updateById(sysCaptcha);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:syscaptcha:delete")
    public R delete(@RequestBody String[] uuids){
			sysCaptchaService.deleteBatchIds(Arrays.asList(uuids));

        return R.ok();
    }

}
