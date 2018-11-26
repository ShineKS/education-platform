package com.little.edu.common.util;

import java.util.UUID;

public class SessionUtil {

    /**
     * 生成session
     * @return
     */
    public static String genSession() {
        return UUID.randomUUID().toString();
    }
}
