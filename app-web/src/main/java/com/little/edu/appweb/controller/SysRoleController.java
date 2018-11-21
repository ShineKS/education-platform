package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.SysRoleEntity;
import com.little.edu.appweb.service.SysRoleService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 角色
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@RestController
@RequestMapping("generator/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("generator:sysrole:info")
    public R info(@PathVariable("roleId") Long roleId){
			SysRoleEntity sysRole = sysRoleService.selectById(roleId);

        return R.ok().put("sysRole", sysRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysrole:save")
    public R save(@RequestBody SysRoleEntity sysRole){
			sysRoleService.insert(sysRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysrole:update")
    public R update(@RequestBody SysRoleEntity sysRole){
			sysRoleService.updateById(sysRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysrole:delete")
    public R delete(@RequestBody Long[] roleIds){
			sysRoleService.deleteBatchIds(Arrays.asList(roleIds));

        return R.ok();
    }

}
