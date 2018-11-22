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

import com.little.edu.appweb.modules.smallapp.entity.WeixinUserEntity;
import com.little.edu.appweb.modules.smallapp.service.WeixinUserService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 用于记录所有微信访问的用户
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/weixinuser")
public class WeixinUserController {
    @Autowired
    private WeixinUserService weixinUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:weixinuser:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = weixinUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:weixinuser:info")
    public R info(@PathVariable("id") Long id){
			WeixinUserEntity weixinUser = weixinUserService.selectById(id);

        return R.ok().put("weixinUser", weixinUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:weixinuser:save")
    public R save(@RequestBody WeixinUserEntity weixinUser){
			weixinUserService.insert(weixinUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:weixinuser:update")
    public R update(@RequestBody WeixinUserEntity weixinUser){
			weixinUserService.updateById(weixinUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:weixinuser:delete")
    public R delete(@RequestBody Long[] ids){
			weixinUserService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
