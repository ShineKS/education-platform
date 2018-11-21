package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.GrowDiaryEntity;
import com.little.edu.appweb.service.GrowDiaryService;
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
 * 成长日记日记表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/growdiary")
public class GrowDiaryController {
    @Autowired
    private GrowDiaryService growDiaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:growdiary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growDiaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:growdiary:info")
    public R info(@PathVariable("id") Long id){
			GrowDiaryEntity growDiary = growDiaryService.selectById(id);

        return R.ok().put("growDiary", growDiary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:growdiary:save")
    public R save(@RequestBody GrowDiaryEntity growDiary){
			growDiaryService.insert(growDiary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:growdiary:update")
    public R update(@RequestBody GrowDiaryEntity growDiary){
			growDiaryService.updateById(growDiary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:growdiary:delete")
    public R delete(@RequestBody Long[] ids){
			growDiaryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
