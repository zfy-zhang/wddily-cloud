package com.alisha.wddily.utils.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 基础工具类
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Modify
 * @since
 */
public class ToolUtils {


    private ToolUtils(){}

    // 判断数字正则表达式
    private static final Pattern pattern = Pattern.compile("[0-9]*");

    public static boolean checkInt(String str) {
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        } else {
            return true;
        }
    }

    public static Integer str2Int(String str) {
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return 0;
        } else {
            return Integer.parseInt(str);
        }
    }

    public static LocalDateTime str2LocalDateTime(String dateStr) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.parse(dateStr,df);
        return ldt;
    }

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
