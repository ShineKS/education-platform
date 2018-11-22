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

import com.little.edu.appweb.modules.smallapp.entity.StudentEntity;
import com.little.edu.appweb.modules.smallapp.service.StudentService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 学员表
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:student:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = studentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:student:info")
    public R info(@PathVariable("id") Long id){
			StudentEntity student = studentService.selectById(id);

        return R.ok().put("student", student);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:student:save")
    public R save(@RequestBody StudentEntity student){
			studentService.insert(student);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:student:update")
    public R update(@RequestBody StudentEntity student){
			studentService.updateById(student);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:student:delete")
    public R delete(@RequestBody Long[] ids){
			studentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
