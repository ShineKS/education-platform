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

import com.little.edu.appweb.modules.smallapp.entity.RemarkTemplateEntity;
import com.little.edu.appweb.modules.smallapp.service.RemarkTemplateService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 阶段评价模板
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/remarktemplate")
public class RemarkTemplateController {
    @Autowired
    private RemarkTemplateService remarkTemplateService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:remarktemplate:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = remarkTemplateService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:remarktemplate:info")
    public R info(@PathVariable("id") Long id){
			RemarkTemplateEntity remarkTemplate = remarkTemplateService.selectById(id);

        return R.ok().put("remarkTemplate", remarkTemplate);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:remarktemplate:save")
    public R save(@RequestBody RemarkTemplateEntity remarkTemplate){
			remarkTemplateService.insert(remarkTemplate);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:remarktemplate:update")
    public R update(@RequestBody RemarkTemplateEntity remarkTemplate){
			remarkTemplateService.updateById(remarkTemplate);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:remarktemplate:delete")
    public R delete(@RequestBody Long[] ids){
			remarkTemplateService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
