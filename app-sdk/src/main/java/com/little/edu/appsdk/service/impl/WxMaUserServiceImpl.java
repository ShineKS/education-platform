package com.little.edu.appsdk.service.impl;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.little.edu.appsdk.bean.WxMaJscode2SessionResult;
import com.little.edu.appsdk.bean.WxMaPhoneNumberInfo;
import com.little.edu.appsdk.bean.WxMaUserInfo;
import com.little.edu.appsdk.service.WxMaConfig;
import com.little.edu.appsdk.service.WxMaService;
import com.little.edu.appsdk.service.WxMaUserService;
import com.little.edu.appsdk.util.crypt.WxMaCryptUtils;
import com.little.edu.common.error.WxError;
import com.little.edu.common.error.WxErrorException;
import com.little.edu.common.util.SignUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Service
public class WxMaUserServiceImpl implements WxMaUserService {
  @Autowired
  private WxMaService service;

  public WxMaUserServiceImpl(WxMaService service) {
    this.service = service;
  }

  @Override
  public WxMaJscode2SessionResult getSessionInfo(String jsCode) throws WxErrorException {
    return service.jsCode2SessionInfo(jsCode);
  }

  @Override
  public WxMaUserInfo getUserInfo(String sessionKey, String encryptedData, String ivStr) {
    return WxMaUserInfo.fromJson(WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr));
  }

  @Override
  public void setUserStorage(Map<String, String> kvMap, String sessionKey, String openid) throws WxErrorException {
    final WxMaConfig config = this.service.getWxMaConfig();
    JsonObject param = new JsonObject();
    JsonArray array = new JsonArray();
    for (Map.Entry<String, String> e : kvMap.entrySet()) {
      JsonObject jsonObject = new JsonObject();
      jsonObject.addProperty("key", e.getKey());
      jsonObject.addProperty("value", e.getValue());
      array.add(jsonObject);
    }
    param.add("kv_list", array);
    String params = param.toString();
    String signature = SignUtils.createHmacSha256Sign(params, sessionKey);
    String url = String.format("https://api.weixin.qq.com/wxa/set_user_storage" +
        "?appid=%s&signature=%s&openid=%s&sig_method=%s",
      config.getAppid(), signature, openid, "hmac_sha256");
    String result = this.service.post(url, params);
    WxError error = WxError.fromJson(result);
    if (error.getErrorCode() != 0) {
      throw new WxErrorException(error);
    }
  }

  @Override
  public WxMaPhoneNumberInfo getPhoneNoInfo(String sessionKey, String encryptedData, String ivStr) {
    return WxMaPhoneNumberInfo.fromJson(WxMaCryptUtils.decrypt(sessionKey, encryptedData, ivStr));
  }

  @Override
  public boolean checkUserInfo(String sessionKey, String rawData, String signature) {
    final String generatedSignature = DigestUtils.sha1Hex(rawData + sessionKey);
    return generatedSignature.equals(signature);
  }

}
