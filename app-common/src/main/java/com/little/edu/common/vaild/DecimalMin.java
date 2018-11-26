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
 * 最小数值检查
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DecimalMin {

    /**
     * 最小值
     *
     * @return 最小值
     */
    double value();

    /**
     * 错误信息
     *
     * @return 错误信息
     */
    String message();

    /**
     * 检查场景
     *
     * @return 检查场景
     */
    String sence() default "ALL";
}
