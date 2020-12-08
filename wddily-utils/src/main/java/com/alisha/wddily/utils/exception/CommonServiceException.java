package com.alisha.wddily.utils.exception;

import lombok.Data;

/**
 * @Description: 公共业务逻辑异常
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class CommonServiceException extends Exception {

    private Integer code;
    private String message;

    public CommonServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
