package com.little.edu.common.util.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.little.edu.common.bean.WxAccessToken;
import com.little.edu.common.bean.menu.WxMenu;
import com.little.edu.common.bean.result.WxMediaUploadResult;
import com.little.edu.common.error.WxError;
import com.little.edu.common.bean.WxAccessToken;
import com.little.edu.common.bean.menu.WxMenu;
import com.little.edu.common.error.WxError;
import com.little.edu.common.bean.result.WxMediaUploadResult;

public class WxGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxAccessToken.class, new WxAccessTokenAdapter());
    INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
    INSTANCE.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMediaUploadResult.class, new WxMediaUploadResultAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
