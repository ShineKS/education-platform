package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.SysUserTokenEntity;
import com.little.edu.appweb.service.SysUserTokenService;
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
 * 系统用户Token
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@RestController
@RequestMapping("generator/sysusertoken")
public class SysUserTokenController {
    @Autowired
    private SysUserTokenService sysUserTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysusertoken:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    @RequiresPermissions("generator:sysusertoken:info")
    public R info(@PathVariable("userId") Long userId){
			SysUserTokenEntity sysUserToken = sysUserTokenService.selectById(userId);

        return R.ok().put("sysUserToken", sysUserToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysusertoken:save")
    public R save(@RequestBody SysUserTokenEntity sysUserToken){
			sysUserTokenService.insert(sysUserToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysusertoken:update")
    public R update(@RequestBody SysUserTokenEntity sysUserToken){
			sysUserTokenService.updateById(sysUserToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysusertoken:delete")
    public R delete(@RequestBody Long[] userIds){
			sysUserTokenService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
