package com.little.edu.appsdk.builder;


import com.little.edu.appsdk.bean.WxMaKefuMessage;
import com.little.edu.appsdk.constant.WxMaConstants;

/**
 * 图片消息builder.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public final class ImageMessageBuilder extends BaseBuilder<ImageMessageBuilder> {
  private String mediaId;

  public ImageMessageBuilder() {
    this.msgType = WxMaConstants.KefuMsgType.IMAGE;
  }

  public ImageMessageBuilder mediaId(String mediaId) {
    this.mediaId = mediaId;
    return this;
  }

  @Override
  public WxMaKefuMessage build() {
    WxMaKefuMessage m = super.build();
    m.setImage(new WxMaKefuMessage.KfImage(this.mediaId));
    return m;
  }
}
