package com.little.edu.appsdk.service.impl;

import com.little.edu.appsdk.bean.WxMaCodeLineColor;
import com.little.edu.appsdk.bean.WxMaQrcode;
import com.little.edu.appsdk.bean.WxMaWxcode;
import com.little.edu.appsdk.bean.WxaCodeUnlimit;
import com.little.edu.appsdk.service.WxMaQrcodeService;
import com.little.edu.appsdk.service.WxMaService;
import com.little.edu.appsdk.util.http.QrCodeRequestExecutor;
import me.chanjar.weixin.common.error.WxErrorException;

import java.io.File;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaQrcodeServiceImpl implements WxMaQrcodeService {
  private WxMaService wxMaService;

  public WxMaQrcodeServiceImpl(WxMaService wxMaService) {
    this.wxMaService = wxMaService;
  }

  @Override
  public File createQrcode(String path, int width) throws WxErrorException {
    return this.wxMaService.execute(new QrCodeRequestExecutor(this.wxMaService.getRequestHttp()),
      CREATE_QRCODE_URL, new WxMaQrcode(path, width));
  }

  @Override
  public File createQrcode(String path) throws WxErrorException {
    return this.createQrcode(path, 430);
  }

  @Override
  public File createWxaCode(String path, int width, boolean autoColor, WxMaCodeLineColor lineColor, boolean isHyaline) throws WxErrorException {
    WxMaWxcode wxMaWxcode = new WxMaWxcode();
    wxMaWxcode.setPath(path);
    wxMaWxcode.setWidth(width);
    wxMaWxcode.setAutoColor(autoColor);
    wxMaWxcode.setLineColor(lineColor);
    wxMaWxcode.setHyaline(isHyaline);
    return this.wxMaService.execute(new QrCodeRequestExecutor(this.wxMaService.getRequestHttp()),
      GET_WXACODE_URL, wxMaWxcode);
  }

  @Override
  public File createWxaCode(String path, int width) throws WxErrorException {
    return this.createWxaCode(path, width, true, null, false);
  }

  @Override
  public File createWxaCode(String path) throws WxErrorException {
    return this.createWxaCode(path, 430, true, null, false);
  }

  @Override
  public File createWxaCodeUnlimit(String scene, String page, int width, boolean autoColor, WxMaCodeLineColor lineColor, boolean isHyaline)
    throws WxErrorException {
    WxaCodeUnlimit wxaCodeUnlimit = new WxaCodeUnlimit();
    wxaCodeUnlimit.setScene(scene);
    wxaCodeUnlimit.setPage(page);
    wxaCodeUnlimit.setWidth(width);
    wxaCodeUnlimit.setAutoColor(autoColor);
    wxaCodeUnlimit.setLineColor(lineColor);
    wxaCodeUnlimit.setHyaline(isHyaline);
    return this.wxMaService.execute(new QrCodeRequestExecutor(this.wxMaService.getRequestHttp()),
      GET_WXACODE_UNLIMIT_URL, wxaCodeUnlimit);
  }

  @Override
  public File createWxaCodeUnlimit(String scene, String page) throws WxErrorException {
    return this.createWxaCodeUnlimit(scene, page, 430, true, null, false);
  }

}
