package com.alisha.wddily.utils.common.vo;

import com.alisha.wddily.utils.exception.CommonServiceException;

/**
 * @Description: 公共的请求对象
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public abstract class BaseRequestVO {

    /**
     * @Description: 公共的参数验证方法
     *
     */
    public abstract void checkParam() throws CommonServiceException;
}
