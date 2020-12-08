package com.alisha.wddily.user.service;

import com.alisha.wddily.utils.exception.CommonServiceException;

/**
 * @Description: 用户接口
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public interface UserServiceAPI {

    String checkUserLogin(String username, String password) throws CommonServiceException;

}
