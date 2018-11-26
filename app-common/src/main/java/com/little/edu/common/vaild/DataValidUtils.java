/*
 * Copyright (c) 2012-2013, Yunnan Yuan Xin technology Co., Ltd.
 *
 * All rights reserved.
 */
package com.little.edu.common.vaild;

import org.apache.commons.lang.StringUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;


/**
 * 数据校验类
 */
public class DataValidUtils {

    /**
     * 结果类
     *
     * @author HuHongwei
     */
    public static class Result {

        /**
         * 正确与否
         */
        private boolean suc;

        /**
         * 错误信息
         */
        private String msg;

        /**
         * 是否正确
         *
         * @return 正确与否
         */
        public boolean isSuc() {
            return suc;
        }

        /**
         * 设置是否正确
         */
        public void setSuc(boolean suc) {
            this.suc = suc;
        }

        /**
         * 获取错误信息
         *
         * @return 错误信息
         */
        public String getMsg() {
            return msg;
        }

        /**
         * 设置错误信息
         */
        public void setMsg(String msg) {
            this.msg = msg;
        }

        /**
         * 构造函数
         *
         * @param suc 正确与否
         * @param msg 错误信息
         */
        public Result(boolean suc, String msg) {
            super();
            this.suc = suc;
            this.msg = msg;
        }

        /**
         * 构造函数，默认成功
         */
        public Result() {
            super();
            this.suc = true;
        }
    }

    /**
     * 所有场景
     */
    public static final String SENCE_ALL = "ALL";

    /**
     * 校验
     *
     * @param inputData 目标数据
     * @return 校验结果
     */
    public static Result validation(Object inputData) {
        return validation(SENCE_ALL, inputData);
    }

    /**
     * 校验
     *
     * @param sence     场景
     * @param inputData 目标数据
     * @return 校验结果
     */
    public static Result validation(String sence, Object inputData) {
        if (sence == null) {
            return new Result(false, "检查场景为空");
        }
        if (inputData == null) {
            return new Result(false, "输入数据为空");
        }
        Field[] fields = inputData.getClass().getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return new Result();
        }
        for (Field f : fields) {
            f.setAccessible(true);
            Annotation[] anotations = f.getAnnotations();
            if (anotations != null && anotations.length > 0) {
                for (Annotation anno : anotations) {
                    try {
                        Result result = new Result();
                        if (anno.annotationType() == DecimalMax.class) {
                            if (isTaste(sence, anno)) {
                                result = checkDecimalMax(sence, (DecimalMax) anno, f.get(inputData));
                            }
                        } else if (anno.annotationType() == DecimalMin.class) {
                            if (isTaste(sence, anno)) {
                                result = checkDecimalMin(sence, (DecimalMin) anno, f.get(inputData));
                            }
                        } else if (anno.annotationType() == Length.class) {
                            if (isTaste(sence, anno)) {
                                result = checkLength(sence, (Length) anno, f.get(inputData));
                            }
                        } else if (anno.annotationType() == NotNull.class) {
                            if (isTaste(sence, anno)) {
                                result = checkNotNull(sence, (NotNull) anno, f.get(inputData));
                            }
                        } else if (anno.annotationType() == Pattern.class) {
                            if (isTaste(sence, anno)) {
                                result = checkPattern(sence, (Pattern) anno, f.get(inputData));
                            }
                        } else {
                            continue;
                        }

                        if (result == null || !result.isSuc()) {
                            return result;
                        }
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        return new Result(false, "检查异常");
                    }
                }
            }

//                try {
//                    f.setAccessible(true);
//                    Object obj = f.get(inputData);
//                    if (obj != null) {
//                        Result result = validation(sence, obj);
//                        if (result == null || !result.isSuc()) {
//                            return result;
//                        }
//                    }
//                } catch (IllegalArgumentException | IllegalAccessException e) {
//                    return new Result(false, "检查异常");
//                }
        }

        return new Result();
    }

    /**
     * 校验
     *
     * @param sence 场景
     * @param anno  注解
     * @return 是否符合校验场景
     */
    private static boolean isTaste(String sence, Annotation anno) {
        try {
            Method m = anno.annotationType().getMethod("sence");
            String csence = (String) m.invoke(anno);
            if (csence == null) {
                return false;
            }

            if (csence.equals(SENCE_ALL)) {
                return true;
            }

            if (csence.equals(sence)) {
                return true;
            }
        } catch (NoSuchMethodException | SecurityException |
                IllegalAccessException | IllegalArgumentException |
                InvocationTargetException e) {
            return false;
        }

        return false;
    }

    /**
     * 检查最大数字
     *
     * @param sence 场景
     * @param anno  主键
     * @param obj   对象值
     * @return 结果
     */
    private static Result checkDecimalMax(String sence, DecimalMax anno, Object obj) {
        if (obj == null) {
            return new Result();
        } else if (obj instanceof BigDecimal) {
            BigDecimal value = (BigDecimal) obj;
            if (value.compareTo(new BigDecimal(String.valueOf(anno.value()))) > 0) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        } else if (obj instanceof Integer) {
            Integer value = (Integer) obj;
            if (new BigDecimal(value).compareTo(new BigDecimal(String.valueOf(anno.value()))) > 0) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        }

        return new Result(false, "注解类型错误[" + anno.message() + "]");
    }

    /**
     * 校验最小数字
     *
     * @param sence 场景
     * @param anno  主键
     * @param obj   被校验对象
     * @return 结果
     */
    private static Result checkDecimalMin(String sence, DecimalMin anno, Object obj) {
        if (obj == null) {
            return new Result();
        } else if (obj instanceof BigDecimal) {
            BigDecimal value = (BigDecimal) obj;
            if (value.compareTo(new BigDecimal(String.valueOf(anno.value()))) < 0) {//直接用anno.value()来构建的话精度有问题
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        } else if (obj instanceof Integer) {
            Integer value = (Integer) obj;
            if (new BigDecimal(value).compareTo(new BigDecimal(String.valueOf(anno.value()))) < 0) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        }

        return new Result(false, "注解类型错误[" + anno.message() + "]");
    }

    /**
     * 校验数据长度
     *
     * @param sence 场景
     * @param anno  主键
     * @param obj   被校验对象
     * @return 校验结果
     */
    private static Result checkLength(String sence, Length anno, Object obj) {
        if (obj == null) {
            return new Result();
        } else if (obj instanceof String) {
            int len = ((String) obj).length();
            if (len < anno.min() || len > anno.max()) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        } else if (obj instanceof Collection<?>) {
            int len = ((Collection<?>) obj).size();
            if (len < anno.min() || len > anno.max()) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        } else if (obj instanceof Map<?, ?>) {
            int len = ((Map<?, ?>) obj).size();
            if (len < anno.min() || len > anno.max()) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        } else if (obj instanceof Object[]) {
            int len = ((Object[]) obj).length;
            if (len < anno.min() || len > anno.max()) {
                return new Result(false, anno.message());
            } else {
                return new Result();
            }
        }

        return new Result(false, "注解类型错误[" + anno.message() + "]");
    }

    /**
     * 校验是否为空
     *
     * @param sence 场景
     * @param anno  主键
     * @param obj   被校验对象
     * @return 结果
     */
    private static Result checkNotNull(String sence, NotNull anno, Object obj) {
        if (obj == null) {
            return new Result(false, anno.message());
        } else if (!anno.isAllowedBlank()) {
            if (obj instanceof String) {
                if (obj.toString().trim().length() == 0) {
                    return new Result(false, anno.message());
                }
            }
        }

        return new Result();
    }

    /**
     * 校验正则表达式
     *
     * @param sence 场景
     * @param anno  主键
     * @param obj   被校验对象
     * @return 结果
     */
    private static Result checkPattern(String sence, Pattern anno, Object obj) {
        if (obj==null) {
            return new Result();
        } else if (obj instanceof String) {
            if (((String) obj).matches(anno.value())||obj.equals("")) {
                return new Result();
            } else {
                return new Result(false, anno.message());
            }
        }

        return new Result(false, "注解类型错误[" + anno.message() + "]");
    }
}
