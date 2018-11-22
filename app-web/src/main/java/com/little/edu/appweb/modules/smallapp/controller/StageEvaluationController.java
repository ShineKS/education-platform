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

import com.little.edu.appweb.modules.smallapp.entity.StageEvaluationEntity;
import com.little.edu.appweb.modules.smallapp.service.StageEvaluationService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 家长对于每个日记每个阶段的成长之路评价
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/stageevaluation")
public class StageEvaluationController {
    @Autowired
    private StageEvaluationService stageEvaluationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:stageevaluation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stageEvaluationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:stageevaluation:info")
    public R info(@PathVariable("id") Long id){
			StageEvaluationEntity stageEvaluation = stageEvaluationService.selectById(id);

        return R.ok().put("stageEvaluation", stageEvaluation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:stageevaluation:save")
    public R save(@RequestBody StageEvaluationEntity stageEvaluation){
			stageEvaluationService.insert(stageEvaluation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:stageevaluation:update")
    public R update(@RequestBody StageEvaluationEntity stageEvaluation){
			stageEvaluationService.updateById(stageEvaluation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:stageevaluation:delete")
    public R delete(@RequestBody Long[] ids){
			stageEvaluationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
