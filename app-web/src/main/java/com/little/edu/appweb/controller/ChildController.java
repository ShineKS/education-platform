package com.little.edu.appweb.controller;

import com.little.edu.appweb.entity.ChildEntity;
import com.little.edu.appweb.service.ChildService;
import com.little.edu.appweb.utils.PageUtils;
import com.little.edu.appweb.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * 记录每一个孩子的实体
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/child")
public class ChildController {
    @Autowired
    private ChildService childService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:child:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = childService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:child:info")
    public R info(@PathVariable("id") Long id){
			ChildEntity child = childService.selectById(id);

        return R.ok().put("child", child);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:child:save")
    public R save(@RequestBody ChildEntity child){
			childService.insert(child);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:child:update")
    public R update(@RequestBody ChildEntity child){
			childService.updateById(child);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:child:delete")
    public R delete(@RequestBody Long[] ids){
			childService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
