package com.little.edu.appsdk.service.impl;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.little.edu.appsdk.service.WxMaJsapiService;
import com.little.edu.appsdk.service.WxMaService;
import com.little.edu.common.bean.WxJsapiSignature;
import com.little.edu.common.error.WxErrorException;
import com.little.edu.common.util.RandomUtils;
import com.little.edu.common.util.crypto.SHA1;

import java.util.concurrent.locks.Lock;

/**
 * <pre>
 *  Created by BinaryWang on 2018/8/5.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaJsapiServiceImpl implements WxMaJsapiService {

  private static final JsonParser JSON_PARSER = new JsonParser();

  private WxMaService wxMaService;

  public WxMaJsapiServiceImpl(WxMaService wxMaService) {
    this.wxMaService = wxMaService;
  }

  @Override
  public String getJsapiTicket() throws WxErrorException {
    return getJsapiTicket(false);
  }

  @Override
  public String getJsapiTicket(boolean forceRefresh) throws WxErrorException {
    Lock lock = this.wxMaService.getWxMaConfig().getJsapiTicketLock();
    try {
      lock.lock();
      if (forceRefresh) {
        this.wxMaService.getWxMaConfig().expireJsapiTicket();
      }

      if (this.wxMaService.getWxMaConfig().isJsapiTicketExpired()) {
        String responseContent = this.wxMaService.get(GET_JSAPI_TICKET_URL, null);
        JsonElement tmpJsonElement = JSON_PARSER.parse(responseContent);
        JsonObject tmpJsonObject = tmpJsonElement.getAsJsonObject();
        String jsapiTicket = tmpJsonObject.get("ticket").getAsString();
        int expiresInSeconds = tmpJsonObject.get("expires_in").getAsInt();
        this.wxMaService.getWxMaConfig().updateJsapiTicket(jsapiTicket, expiresInSeconds);
      }
    } finally {
      lock.unlock();
    }
    return this.wxMaService.getWxMaConfig().getJsapiTicket();
  }

  @Override
  public WxJsapiSignature createJsapiSignature(String url) throws WxErrorException {
    long timestamp = System.currentTimeMillis() / 1000;
    String randomStr = RandomUtils.getRandomStr();
    String jsapiTicket = getJsapiTicket(false);
    String signature = SHA1.genWithAmple("jsapi_ticket=" + jsapiTicket,
            "noncestr=" + randomStr, "timestamp=" + timestamp, "url=" + url);
    return WxJsapiSignature
            .builder()
            .appId(this.wxMaService.getWxMaConfig().getAppid())
            .timestamp(timestamp)
            .nonceStr(randomStr)
            .url(url)
            .signature(signature)
            .build();
  }
}
