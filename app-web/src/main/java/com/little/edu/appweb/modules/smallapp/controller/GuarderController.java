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

import com.little.edu.appweb.modules.smallapp.entity.GuarderEntity;
import com.little.edu.appweb.modules.smallapp.service.GuarderService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/guarder")
public class GuarderController {
    @Autowired
    private GuarderService guarderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:guarder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = guarderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:guarder:info")
    public R info(@PathVariable("id") Long id){
			GuarderEntity guarder = guarderService.selectById(id);

        return R.ok().put("guarder", guarder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:guarder:save")
    public R save(@RequestBody GuarderEntity guarder){
			guarderService.insert(guarder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:guarder:update")
    public R update(@RequestBody GuarderEntity guarder){
			guarderService.updateById(guarder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:guarder:delete")
    public R delete(@RequestBody Long[] ids){
			guarderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
