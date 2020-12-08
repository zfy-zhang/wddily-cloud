package com.alisha.wddily.user.dao;

import com.alisha.WddilyUserApplicationTests;
import com.alisha.wddily.common.entity.WddilyBackendUserT;
import com.alisha.wddily.common.mapper.WddilyBackendUserTMapper;
import com.alisha.wddily.utils.util.MD5Util;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class UserTest extends WddilyUserApplicationTests {

    @Resource
    private WddilyBackendUserTMapper backendUserTMapper;

    /**
     * @Description: 添加后台运维用户功能
     * @Param: []
     * @return: void
     * @Author: alisha
     */
    @Test
    public void add() {
        WddilyBackendUserT user = new WddilyBackendUserT();
        user.setUserName("admin");
        user.setUserPwd(MD5Util.encrypt("admin123"));
        user.setUserPhone("18588888888");

        backendUserTMapper.insert(user);
    }

    @Test
    public void select() {
        // 查询列表
        List<WddilyBackendUserT> user = backendUserTMapper.selectList(null);
        user.stream().forEach(
                System.out::println
        );

    }

}
