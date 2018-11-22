package com.little.edu.appweb.modules.smallapp.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.little.edu.appweb.modules.smallapp.entity.ChildEntity;
import com.little.edu.appweb.modules.smallapp.service.ChildService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 记录每一个孩子的实体
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/child")
public class ChildController {
    @Autowired
    private ChildService childService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:child:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = childService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:child:info")
    public R info(@PathVariable("id") Long id){
			ChildEntity child = childService.selectById(id);

        return R.ok().put("child", child);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:child:save")
    public R save(@RequestBody ChildEntity child){
			childService.insert(child);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:child:update")
    public R update(@RequestBody ChildEntity child){
			childService.updateById(child);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:child:delete")
    public R delete(@RequestBody Long[] ids){
			childService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
