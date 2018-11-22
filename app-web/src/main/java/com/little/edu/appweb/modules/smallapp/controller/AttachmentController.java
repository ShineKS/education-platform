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

import com.little.edu.appweb.modules.smallapp.entity.AttachmentEntity;
import com.little.edu.appweb.modules.smallapp.service.AttachmentService;
import com.little.edu.appweb.common.utils.PageUtils;
import com.little.edu.appweb.common.utils.R;



/**
 * 附件表
 *
 * @author huangqi
 * @email xxx@gmail.com
 * @date 2018-11-22 16:17:30
 */
@RestController
@RequestMapping("smallapp/attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("smallapp:attachment:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attachmentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("smallapp:attachment:info")
    public R info(@PathVariable("id") Long id){
			AttachmentEntity attachment = attachmentService.selectById(id);

        return R.ok().put("attachment", attachment);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("smallapp:attachment:save")
    public R save(@RequestBody AttachmentEntity attachment){
			attachmentService.insert(attachment);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("smallapp:attachment:update")
    public R update(@RequestBody AttachmentEntity attachment){
			attachmentService.updateById(attachment);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("smallapp:attachment:delete")
    public R delete(@RequestBody Long[] ids){
			attachmentService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
