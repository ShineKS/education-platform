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
 * 字符串长度检查
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {

    /**
     * 最小长度
     *
     * @return 最小长度
     */
    int min() default 0;

    /**
     * 最大长度
     *
     * @return 最大长度
     */
    int max();

    /**
     * 错误信息
     *
     * @return 错误信息
     */
    String message() default "";

    /**
     * 检查场景
     *
     * @return 检查场景
     */
    String sence() default "ALL";

}
