package com.alisha.wddily.user.service.impl;

import com.alisha.wddily.user.dao.entity.WddilyBackendUserT;
import com.alisha.wddily.user.dao.mapper.WddilyBackendUserTMapper;
import com.alisha.wddily.user.service.UserServiceAPI;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.alisha.wddily.utils.util.MD5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用户业务模块实现
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@Service
public class UserServiceImpl implements UserServiceAPI {

    @Autowired
    private WddilyBackendUserTMapper wddilyBackendUserTMapper;

    @Override
    public String checkUserLogin(String username, String password) throws CommonServiceException {
        // 根据用户名获取用户信息
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", username);

        List<WddilyBackendUserT> list = wddilyBackendUserTMapper.selectList(queryWrapper);

        WddilyBackendUserT userT = null;
        if (list != null && list.size() > 0) {
            userT = list.stream().findFirst().get();
        } else {
            throw new CommonServiceException(404, "用户名输入错误");
        }

        // 验证密码是否正确
        String encrypt = MD5Util.encrypt(password);
        if (!encrypt.equals(userT.getUserPwd())) {
            throw new CommonServiceException(500, "用户密码输入有误");
        } else {
            return userT.getUuid() + "";
        }
    }
}
