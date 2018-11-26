/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.little.edu.common.vaild;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 最大数值检查
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DecimalMax {

    /**
     * 最大值
     *
     * @return 最大值
     */
    double value();

    /**
     * 错误消息
     *
     * @return 错误消息
     */
    String message();

    /**
     * 检查业务场景
     *
     * @return 业务场景
     */
    String sence() default "ALL";
}
