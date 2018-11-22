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

import com.little.edu.appweb.modules.smallapp.entity.ClassInfoEntity;
import com.little.edu.appweb.modules.smallapp.service.ClassInfoService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/classinfo")
public class ClassInfoController {
    @Autowired
    private ClassInfoService classInfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:classinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = classInfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:classinfo:info")
    public R info(@PathVariable("id") Long id){
			ClassInfoEntity classInfo = classInfoService.selectById(id);

        return R.ok().put("classInfo", classInfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:classinfo:save")
    public R save(@RequestBody ClassInfoEntity classInfo){
			classInfoService.insert(classInfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:classinfo:update")
    public R update(@RequestBody ClassInfoEntity classInfo){
			classInfoService.updateById(classInfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:classinfo:delete")
    public R delete(@RequestBody Long[] ids){
			classInfoService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
