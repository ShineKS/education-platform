package com.little.edu.appweb.modules.smallapp.controller;


import com.little.edu.appweb.modules.smallapp.reqBean.AppLogin;
import com.little.edu.appweb.modules.smallapp.service.SmallLoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 小程序前端登录接口
 */
@RestController
@RequestMapping("/smallapp")
@Api("APP登录接口")
public class SmallLoginController {

    @Autowired
    private SmallLoginService smallLoginService;

    /**
     * 微信端登录,获取session
     * @return
     */
    @PostMapping("/wxLogin")
    public Object login(@RequestBody AppLogin req) {
        return smallLoginService.appLogin(req);
    }

}
