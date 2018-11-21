package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.SysUserRoleEntity;
import com.little.edu.appweb.service.SysUserRoleService;
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
 * 用户与角色对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:24
 */
@RestController
@RequestMapping("generator/sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysuserrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:sysuserrole:info")
    public R info(@PathVariable("id") Long id){
			SysUserRoleEntity sysUserRole = sysUserRoleService.selectById(id);

        return R.ok().put("sysUserRole", sysUserRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysuserrole:save")
    public R save(@RequestBody SysUserRoleEntity sysUserRole){
			sysUserRoleService.insert(sysUserRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysuserrole:update")
    public R update(@RequestBody SysUserRoleEntity sysUserRole){
			sysUserRoleService.updateById(sysUserRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysuserrole:delete")
    public R delete(@RequestBody Long[] ids){
			sysUserRoleService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
