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

import com.little.edu.appweb.modules.smallapp.entity.GrowStageEntity;
import com.little.edu.appweb.modules.smallapp.service.GrowStageService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 记录每个成长日记的阶段内容
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/growstage")
public class GrowStageController {
    @Autowired
    private GrowStageService growStageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:growstage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = growStageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:growstage:info")
    public R info(@PathVariable("id") Long id){
			GrowStageEntity growStage = growStageService.selectById(id);

        return R.ok().put("growStage", growStage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:growstage:save")
    public R save(@RequestBody GrowStageEntity growStage){
			growStageService.insert(growStage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:growstage:update")
    public R update(@RequestBody GrowStageEntity growStage){
			growStageService.updateById(growStage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:growstage:delete")
    public R delete(@RequestBody Long[] ids){
			growStageService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
