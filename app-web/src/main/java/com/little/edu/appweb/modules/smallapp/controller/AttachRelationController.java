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

import com.little.edu.appweb.modules.smallapp.entity.AttachRelationEntity;
import com.little.edu.appweb.modules.smallapp.service.AttachRelationService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 附件资源关系表
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/attachrelation")
public class AttachRelationController {
    @Autowired
    private AttachRelationService attachRelationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:attachrelation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attachRelationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:attachrelation:info")
    public R info(@PathVariable("id") Long id){
			AttachRelationEntity attachRelation = attachRelationService.selectById(id);

        return R.ok().put("attachRelation", attachRelation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:attachrelation:save")
    public R save(@RequestBody AttachRelationEntity attachRelation){
			attachRelationService.insert(attachRelation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:attachrelation:update")
    public R update(@RequestBody AttachRelationEntity attachRelation){
			attachRelationService.updateById(attachRelation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:attachrelation:delete")
    public R delete(@RequestBody Long[] ids){
			attachRelationService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
