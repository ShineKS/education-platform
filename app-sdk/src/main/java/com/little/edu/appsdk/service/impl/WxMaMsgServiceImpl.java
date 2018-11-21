package com.little.edu.appsdk.service.impl;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.little.edu.appsdk.bean.WxMaKefuMessage;
import com.little.edu.appsdk.bean.WxMaTemplateMessage;
import com.little.edu.appsdk.bean.WxMaUniformMessage;
import com.little.edu.appsdk.constant.WxMaConstants;
import com.little.edu.appsdk.service.WxMaMsgService;
import com.little.edu.appsdk.service.WxMaService;
import com.little.edu.common.error.WxError;
import com.little.edu.common.error.WxErrorException;


/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaMsgServiceImpl implements WxMaMsgService {
  private static final JsonParser JSON_PARSER = new JsonParser();
  private WxMaService wxMaService;

  public WxMaMsgServiceImpl(WxMaService wxMaService) {
    this.wxMaService = wxMaService;
  }

  @Override
  public boolean sendKefuMsg(WxMaKefuMessage message) throws WxErrorException {
    String responseContent = this.wxMaService.post(KEFU_MESSAGE_SEND_URL, message.toJson());
    return responseContent != null;
  }

  @Override
  public void sendTemplateMsg(WxMaTemplateMessage templateMessage) throws WxErrorException {
    String responseContent = this.wxMaService.post(TEMPLATE_MSG_SEND_URL, templateMessage.toJson());
    JsonObject jsonObject = JSON_PARSER.parse(responseContent).getAsJsonObject();
    if (jsonObject.get(WxMaConstants.ERRCODE).getAsInt() != 0) {
      throw new WxErrorException(WxError.fromJson(responseContent));
    }
  }

  @Override
  public void sendUniformMsg(WxMaUniformMessage uniformMessage) throws WxErrorException {
    String responseContent = this.wxMaService.post(UNIFORM_MSG_SEND_URL, uniformMessage.toJson());
    JsonObject jsonObject = JSON_PARSER.parse(responseContent).getAsJsonObject();
    if (jsonObject.get(WxMaConstants.ERRCODE).getAsInt() != 0) {
      throw new WxErrorException(WxError.fromJson(responseContent));
    }
  }

}
