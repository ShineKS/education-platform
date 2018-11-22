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

import com.little.edu.appweb.modules.smallapp.entity.OrgEntity;
import com.little.edu.appweb.modules.smallapp.service.OrgService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 公司表
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:org:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orgService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:org:info")
    public R info(@PathVariable("id") Long id){
			OrgEntity org = orgService.selectById(id);

        return R.ok().put("org", org);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:org:save")
    public R save(@RequestBody OrgEntity org){
			orgService.insert(org);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:org:update")
    public R update(@RequestBody OrgEntity org){
			orgService.updateById(org);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:org:delete")
    public R delete(@RequestBody Long[] ids){
			orgService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
