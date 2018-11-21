package com.little.edu.appsdk.util.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.little.edu.appsdk.bean.WxMaTemplateMessage;
import com.little.edu.appsdk.bean.WxMaUniformMessage;
import com.little.edu.appsdk.bean.analysis.WxMaRetainInfo;
import com.little.edu.appsdk.bean.analysis.WxMaUserPortrait;
import com.little.edu.appsdk.bean.analysis.WxMaVisitDistribution;
import com.little.edu.appsdk.bean.code.WxMaCodeCommitRequest;
import com.little.edu.appsdk.bean.code.WxMaCodeVersionDistribution;


/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaGsonBuilder {
  private static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxMaTemplateMessage.class, new WxMaTemplateMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaUniformMessage.class, new WxMaUniformMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaCodeCommitRequest.class, new WxMaCodeCommitRequestGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaCodeVersionDistribution.class, new WxMaCodeVersionDistributionGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaVisitDistribution.class, new WxMaVisitDistributionGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaRetainInfo.class, new WxMaRetainInfoGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaUserPortrait.class, new WxMaUserPortraitGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
