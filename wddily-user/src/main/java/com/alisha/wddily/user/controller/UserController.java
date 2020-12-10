package com.alisha.wddily.user.controller;

import com.alisha.wddily.user.controller.vo.LoginReqVO;
import com.alisha.wddily.user.service.UserServiceAPI;
import com.alisha.wddily.utils.common.vo.BaseResponseVO;
import com.alisha.wddily.utils.exception.CommonServiceException;
import com.alisha.wddily.utils.properties.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserServiceAPI userServiceAPI;

    @Autowired
    public UserController(UserServiceAPI userServiceAPI) {
        this.userServiceAPI = userServiceAPI;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResponseVO login(@RequestBody LoginReqVO reqVO) throws CommonServiceException {
        // 数据验证
        reqVO.checkParam();

        String userId = userServiceAPI.checkUserLogin(reqVO.getUsername(), reqVO.getPassword());

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        String randomKey = jwtTokenUtil.getRandomKey();
        String token = jwtTokenUtil.generateToken(userId, randomKey);
        Map<String, String> result = new HashMap<>();
        result.put("randomKey", randomKey);
        result.put("token", token);
        return BaseResponseVO.success(result);
    }
}
