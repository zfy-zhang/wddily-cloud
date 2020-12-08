package com.alisha.wddily.utils.common.vo;

import com.alisha.wddily.utils.exception.CommonServiceException;
import lombok.Data;

/**
 * @Description: 公共的返回对象
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class BaseResponseVO<M> {

    private Integer code;   // 业务编号
    private String message; // 异常信息
    private M data;         // 业务返回数据

    private BaseResponseVO() {}

    // 成功无参数
    public static BaseResponseVO success() {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        return response;
    }

    // 成功有参数
    public static<M> BaseResponseVO success(M data) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(200);
        response.setMessage("");
        response.setData(data);
        return response;
    }

    // 出现业务异常
    public static<M> BaseResponseVO serviceException(CommonServiceException e) {
        BaseResponseVO response = new BaseResponseVO();
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

}
