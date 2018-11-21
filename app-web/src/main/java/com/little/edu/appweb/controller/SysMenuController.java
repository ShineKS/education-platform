package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.SysMenuEntity;
import com.little.edu.appweb.service.SysMenuService;
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
 * 菜单管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/sysmenu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:sysmenu:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysMenuService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("generator:sysmenu:info")
    public R info(@PathVariable("menuId") Long menuId){
			SysMenuEntity sysMenu = sysMenuService.selectById(menuId);

        return R.ok().put("sysMenu", sysMenu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:sysmenu:save")
    public R save(@RequestBody SysMenuEntity sysMenu){
			sysMenuService.insert(sysMenu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:sysmenu:update")
    public R update(@RequestBody SysMenuEntity sysMenu){
			sysMenuService.updateById(sysMenu);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:sysmenu:delete")
    public R delete(@RequestBody Long[] menuIds){
			sysMenuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }

}
