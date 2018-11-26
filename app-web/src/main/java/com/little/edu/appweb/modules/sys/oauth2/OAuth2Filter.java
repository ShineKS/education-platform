package com.little.edu.appweb.modules.sys.oauth2;

import com.google.gson.Gson;
import com.little.edu.appweb.common.utils.HttpContextUtils;
import com.little.edu.appweb.common.utils.R;
import com.little.edu.appweb.common.utils.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * oauth2过滤器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 13:00
 */

public class OAuth2Filter extends AuthenticatingFilter {

    private RedisUtils redisUtils;

    public OAuth2Filter(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token
        String token = getHeaderParam("token", request);

        if (StringUtils.isBlank(token)) {
            return null;
        }

        return new OAuth2Token(token);
    }

    /**
     * 在这里拦截判断小程序的各种登录状态
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        //校验微信登录情况
        String session = getHeaderParam("session", request);
        if(StringUtils.isEmpty(session)){
            return false;
        }
        String local = redisUtils.get(session);
        if (StringUtils.isEmpty(local)) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {

        //获取请求token，如果token不存在，直接返回401
        String token = getHeaderParam("token", request);
        return refuseReq(response);

//        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        return refuseReq(response);
    }


    /**
     * 从请求头中获取指定参数
     *
     * @param key
     * @param httpRequest
     * @return
     */
    private String getHeaderParam(String key, ServletRequest httpRequest) {
        //从header中获取token
        HttpServletRequest request = (HttpServletRequest) httpRequest;
        String token = request.getHeader(key);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = httpRequest.getParameter(key);
        }
        return token;
    }


    private boolean refuseReq(ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());
        try {
            //处理登录失败的异常
//            Throwable throwable = e.getCause() == null ? e : e.getCause();
            R r = R.error(HttpStatus.SC_UNAUTHORIZED, "无权访问");
            String json = new Gson().toJson(r);
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {

        }
        return false;
    }


}
