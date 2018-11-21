package com.little.edu.appsdk.builder;

import com.little.edu.appsdk.bean.WxMaKefuMessage;
import com.little.edu.appsdk.constant.WxMaConstants;

/**
 * 文本消息builder.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public final class TextMessageBuilder extends BaseBuilder<TextMessageBuilder> {
  private String content;

  public TextMessageBuilder() {
    this.msgType = WxMaConstants.KefuMsgType.TEXT;
  }

  public TextMessageBuilder content(String content) {
    this.content = content;
    return this;
  }

  @Override
  public WxMaKefuMessage build() {
    WxMaKefuMessage m = super.build();
    m.setText(new WxMaKefuMessage.KfText(this.content));
    return m;
  }
}
