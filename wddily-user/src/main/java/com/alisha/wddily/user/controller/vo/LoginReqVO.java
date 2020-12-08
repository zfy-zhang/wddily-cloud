package com.alisha.wddily.user.controller.vo;

import com.alisha.wddily.utils.common.vo.BaseRequestVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.alisha.wddily.utils.util.ToolUtils;
import lombok.Data;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Data
public class LoginReqVO extends BaseRequestVO {

    private String username;
    private String password;

    @Override
    public void checkParam() throws CommonServiceException {
        // 验证数据合法性
        if (ToolUtils.strIsNull(username) || ToolUtils.strIsNull(password)) {
            throw  new CommonServiceException(404, " username or password is not null");
        }
    }
}
