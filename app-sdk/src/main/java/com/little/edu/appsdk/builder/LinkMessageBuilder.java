package com.little.edu.appsdk.builder;


import com.little.edu.appsdk.bean.WxMaKefuMessage;
import com.little.edu.appsdk.constant.WxMaConstants;

/**
 * 图文链接消息builder
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class LinkMessageBuilder extends BaseBuilder<LinkMessageBuilder> {
  private String title;
  private String description;
  private String url;
  private String thumbUrl;

  public LinkMessageBuilder() {
    this.msgType = WxMaConstants.KefuMsgType.LINK;
  }

  public LinkMessageBuilder title(String title) {
    this.title = title;
    return this;
  }

  public LinkMessageBuilder description(String description) {
    this.description = description;
    return this;
  }

  public LinkMessageBuilder url(String url) {
    this.url = url;
    return this;
  }

  public LinkMessageBuilder thumbUrl(String thumbUrl) {
    this.thumbUrl = thumbUrl;
    return this;
  }

  @Override
  public WxMaKefuMessage build() {
    WxMaKefuMessage m = super.build();
    m.setLink(WxMaKefuMessage.KfLink.builder().title(this.title)
      .description(this.description)
      .url(this.url)
      .thumbUrl(this.thumbUrl)
      .build()
    );
    return m;
  }
}
