package com.little.edu.common.util;

import com.little.edu.common.api.WxErrorExceptionHandler;
import com.little.edu.common.api.WxErrorExceptionHandler;
import com.little.edu.common.error.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogExceptionHandler implements WxErrorExceptionHandler {

  private Logger log = LoggerFactory.getLogger(WxErrorExceptionHandler.class);

  @Override
  public void handle(WxErrorException e) {

    this.log.error("Error happens", e);

  }

}
