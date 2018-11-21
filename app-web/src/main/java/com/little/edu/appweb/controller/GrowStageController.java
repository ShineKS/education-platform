package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.GrowStageEntity;
import com.little.edu.appweb.service.GrowStageService;
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
 * 记录每个成长日记的阶段内容
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/growstage")
public class GrowStageController {
    @Autowired
    private GrowStageService growStageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:growstage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growStageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:growstage:info")
    public R info(@PathVariable("id") Long id){
			GrowStageEntity growStage = growStageService.selectById(id);

        return R.ok().put("growStage", growStage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:growstage:save")
    public R save(@RequestBody GrowStageEntity growStage){
			growStageService.insert(growStage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:growstage:update")
    public R update(@RequestBody GrowStageEntity growStage){
			growStageService.updateById(growStage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:growstage:delete")
    public R delete(@RequestBody Long[] ids){
			growStageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
