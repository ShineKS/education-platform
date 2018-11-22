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

import com.little.edu.appweb.modules.smallapp.entity.CourseLibaryEntity;
import com.little.edu.appweb.modules.smallapp.service.CourseLibaryService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 课程库表,记录机构的所有课程
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/courselibary")
public class CourseLibaryController {
    @Autowired
    private CourseLibaryService courseLibaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:courselibary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = courseLibaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:courselibary:info")
    public R info(@PathVariable("id") Long id){
			CourseLibaryEntity courseLibary = courseLibaryService.selectById(id);

        return R.ok().put("courseLibary", courseLibary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:courselibary:save")
    public R save(@RequestBody CourseLibaryEntity courseLibary){
			courseLibaryService.insert(courseLibary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:courselibary:update")
    public R update(@RequestBody CourseLibaryEntity courseLibary){
			courseLibaryService.updateById(courseLibary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:courselibary:delete")
    public R delete(@RequestBody Long[] ids){
			courseLibaryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
