package com.little.edu.appweb.common.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	public static String getDomain(){
		HttpServletRequest request = getHttpServletRequest();
		StringBuffer url = request.getRequestURL();
		return url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();
	}

	public static String getOrigin(){
		HttpServletRequest request = getHttpServletRequest();
		return request.getHeader("Origin");
	}

	/**
	 * 从http中获取指定的请求头参数(用于获取session和token)
	 * @param key
	 * @param req
	 * @return
	 */
	public static String getHeaderParam(String key, ServletRequest req){
		HttpServletRequest request = (HttpServletRequest) req;
		String data = getHeaderParam(key, request);
		return data;
	}

	public static String getHeaderParam(String key, HttpServletRequest req){
		String data = req.getHeader(key);
		//如果header中不存在token，则从参数中获取token
		if (StringUtils.isBlank(data)) {
			data = req.getParameter(key);
		}
		return data;
	}
}
