package com.little.edu.appweb.controller;

import java.util.Arrays;
import java.util.Map;

import com.little.edu.appweb.entity.GrowStageItemScoreEntity;
import com.little.edu.appweb.service.GrowStageItemScoreService;
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
 * 成长之路报告表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-11-21 21:50:52
 */
@RestController
@RequestMapping("generator/growstageitemscore")
public class GrowStageItemScoreController {
    @Autowired
    private GrowStageItemScoreService growStageItemScoreService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:growstageitemscore:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growStageItemScoreService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:growstageitemscore:info")
    public R info(@PathVariable("id") Long id){
			GrowStageItemScoreEntity growStageItemScore = growStageItemScoreService.selectById(id);

        return R.ok().put("growStageItemScore", growStageItemScore);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:growstageitemscore:save")
    public R save(@RequestBody GrowStageItemScoreEntity growStageItemScore){
			growStageItemScoreService.insert(growStageItemScore);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:growstageitemscore:update")
    public R update(@RequestBody GrowStageItemScoreEntity growStageItemScore){
			growStageItemScoreService.updateById(growStageItemScore);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:growstageitemscore:delete")
    public R delete(@RequestBody Long[] ids){
			growStageItemScoreService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
