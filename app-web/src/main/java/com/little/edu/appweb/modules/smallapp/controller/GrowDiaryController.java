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

import com.little.edu.appweb.modules.smallapp.entity.GrowDiaryEntity;
import com.little.edu.appweb.modules.smallapp.service.GrowDiaryService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 成长日记日记表
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/growdiary")
public class GrowDiaryController {
    @Autowired
    private GrowDiaryService growDiaryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:growdiary:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growDiaryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:growdiary:info")
    public R info(@PathVariable("id") Long id){
			GrowDiaryEntity growDiary = growDiaryService.selectById(id);

        return R.ok().put("growDiary", growDiary);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:growdiary:save")
    public R save(@RequestBody GrowDiaryEntity growDiary){
			growDiaryService.insert(growDiary);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:growdiary:update")
    public R update(@RequestBody GrowDiaryEntity growDiary){
			growDiaryService.updateById(growDiary);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:growdiary:delete")
    public R delete(@RequestBody Long[] ids){
			growDiaryService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
