package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.SysRoleMenuEntity;
import com.little.edu.appweb.service.SysRoleMenuService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 角色与菜单对应关系
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:53:31
 */
@RestController
@RequestMapping("generator/sysrolemenu")
public class SysRoleMenuController {
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysrolemenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysRoleMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:sysrolemenu:info")
    public R info(@PathVariable("id") Long id){
			SysRoleMenuEntity sysRoleMenu = sysRoleMenuService.selectById(id);

        return R.ok().put("sysRoleMenu", sysRoleMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysrolemenu:save")
    public R save(@RequestBody SysRoleMenuEntity sysRoleMenu){
			sysRoleMenuService.insert(sysRoleMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysrolemenu:update")
    public R update(@RequestBody SysRoleMenuEntity sysRoleMenu){
			sysRoleMenuService.updateById(sysRoleMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysrolemenu:delete")
    public R delete(@RequestBody Long[] ids){
			sysRoleMenuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
