package com.alisha.wddily.utils.util;

/**
 * @Description: 基础工具类
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class ToolUtils {

    private ToolUtils() {}

    /**
     * 字符串为空
     * @param str
     * @return
     */
    public static boolean strIsNull(String str) {
        if (str == null || str.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 字符串不为空
     * @param str
     * @return
     */
    public static boolean strIsNotNull(String str) {
        if (strIsNull(str)) {
            return false;
        } else {
            return true;
        }
    }
}
