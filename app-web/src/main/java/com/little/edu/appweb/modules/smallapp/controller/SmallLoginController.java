package com.little.edu.appweb.modules.smallapp.controller;


import com.little.edu.appweb.modules.smallapp.reqBean.AppLogin;
import com.little.edu.appweb.modules.smallapp.service.SmallLoginService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
    public Object login(HttpServletRequest request, @RequestBody AppLogin req) {
        return smallLoginService.appLogin(request,req);
    }

    @PostMapping("/addFuns")
    public Object addFuns() {
        return null;
    }
}
