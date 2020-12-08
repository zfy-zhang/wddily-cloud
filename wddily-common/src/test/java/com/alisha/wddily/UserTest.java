//package com.alisha.wddily;
//
//import com.alisha.WddilyCommonApplicationTests;
//import com.alisha.wddily.common.entity.WddilyBackendUserT;
//import com.alisha.wddily.common.mapper.WddilyBackendUserTMapper;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @Description:
// * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
// * @Modify
// * @since
// */
//public class UserTest extends WddilyCommonApplicationTests {
//
//    @Resource
//    private WddilyBackendUserTMapper backendUserTMapper;
//
//    @Test
//    public void add() {
//        WddilyBackendUserT userT = new WddilyBackendUserT();
//        userT.setUserName("不才人");
//        userT.setUserPwd("111111L");
//        userT.setUserPhone("13255521234");
//        backendUserTMapper.insert(userT);
//    }
//
//    @Test
//    public void select() {
////        WddilyBackendUserT userT = backendUserTMapper.selectById(2);
////        System.out.println("wddilyBackendUserT=" + userT);
//
//        List<WddilyBackendUserT> wddilyBackendUserTS = backendUserTMapper.selectBatchIds(Arrays.asList(2));
//        wddilyBackendUserTS.stream().forEach(
//                System.out::println
//        );
//    }
//
//    @Test
//    public void update() {
//        WddilyBackendUserT userT = new WddilyBackendUserT();
//        userT.setUuid(2);
//        userT.setUserName("pat123");
//        userT.setUserPwd("2222222");
//        userT.setUserPhone("13323231232");
//        backendUserTMapper.updateById(userT);
//
//    }
//
//    @Test
//    public void delete() {
//        backendUserTMapper.deleteById(2);
//    }
//}
