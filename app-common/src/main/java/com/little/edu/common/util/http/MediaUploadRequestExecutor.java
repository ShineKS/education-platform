package com.little.edu.common.util.http;

import com.little.edu.common.bean.result.WxMediaUploadResult;
import com.little.edu.common.util.http.jodd.JoddHttpMediaUploadRequestExecutor;
import com.little.edu.common.bean.result.WxMediaUploadResult;
import com.little.edu.common.util.http.apache.ApacheMediaUploadRequestExecutor;
import com.little.edu.common.util.http.jodd.JoddHttpMediaUploadRequestExecutor;
import com.little.edu.common.util.http.okhttp.OkHttpMediaUploadRequestExecutor;

import java.io.File;

/**
 * 上传媒体文件请求执行器，请求的参数是File, 返回的结果是String
 *
 * @author Daniel Qian
 */
public abstract class MediaUploadRequestExecutor<H, P> implements RequestExecutor<WxMediaUploadResult, File> {
  protected RequestHttp<H, P> requestHttp;

  public MediaUploadRequestExecutor(RequestHttp requestHttp) {
    this.requestHttp = requestHttp;
  }

  public static RequestExecutor<WxMediaUploadResult, File> create(RequestHttp requestHttp) {
    switch (requestHttp.getRequestType()) {
      case APACHE_HTTP:
        return new ApacheMediaUploadRequestExecutor(requestHttp);
      case JODD_HTTP:
        return new JoddHttpMediaUploadRequestExecutor(requestHttp);
      case OK_HTTP:
        return new OkHttpMediaUploadRequestExecutor(requestHttp);
      default:
        return null;
    }
  }

}
