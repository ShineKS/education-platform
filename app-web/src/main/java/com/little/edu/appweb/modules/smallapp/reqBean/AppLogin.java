package com.little.edu.appweb.modules.smallapp.reqBean;

import com.little.edu.common.vaild.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * 小程序登录,用于换取session的请求体
 *
 */
@Data
public class AppLogin implements Serializable {
    /**
     * 用于换取session的code
     */
    @NotNull(message = "code为空")
    private String code;
    /**
     * 用于安全验证的rawData
     */
    @NotNull(message = "rawData为空")
    private String rawData;
    /**
     * 签名
     */
    @NotNull(message = "signature为空")
    private String signature;

    /**
     * 加密数据
     */
    @NotNull(message = "encryptedData为空")
    private String encryptedData;
    /**
     * 向量
     */
    @NotNull(message = "iv为空")
    private String iv;
}
