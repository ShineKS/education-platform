package com.little.edu.common.util.http.apache;

import com.little.edu.common.bean.result.WxMediaUploadResult;
import com.little.edu.common.error.WxError;
import com.little.edu.common.error.WxErrorException;
import com.little.edu.common.util.http.MediaUploadRequestExecutor;
import com.little.edu.common.util.http.RequestHttp;
import com.little.edu.common.error.WxError;
import com.little.edu.common.bean.result.WxMediaUploadResult;
import com.little.edu.common.error.WxErrorException;
import com.little.edu.common.util.http.MediaUploadRequestExecutor;
import com.little.edu.common.util.http.RequestHttp;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.File;
import java.io.IOException;

/**
 * Created by ecoolper on 2017/5/5.
 */
public class ApacheMediaUploadRequestExecutor extends MediaUploadRequestExecutor<CloseableHttpClient, HttpHost> {
  public ApacheMediaUploadRequestExecutor(RequestHttp requestHttp) {
    super(requestHttp);
  }

  @Override
  public WxMediaUploadResult execute(String uri, File file) throws WxErrorException, IOException {
    HttpPost httpPost = new HttpPost(uri);
    if (requestHttp.getRequestHttpProxy() != null) {
      RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
      httpPost.setConfig(config);
    }
    if (file != null) {
      HttpEntity entity = MultipartEntityBuilder
        .create()
        .addBinaryBody("media", file)
        .setMode(HttpMultipartMode.RFC6532)
        .build();
      httpPost.setEntity(entity);
    }
    try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpPost)) {
      String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
      WxError error = WxError.fromJson(responseContent);
      if (error.getErrorCode() != 0) {
        throw new WxErrorException(error);
      }
      return WxMediaUploadResult.fromJson(responseContent);
    } finally {
      httpPost.releaseConnection();
    }
  }
}
