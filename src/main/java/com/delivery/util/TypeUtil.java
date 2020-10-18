package com.delivery.util;

/**
 * @author Yvan
 * @Description 类型工具类
 * @Classname TypeUtil
 * @Date 2020/10/18 16:19
 */
public class TypeUtil {

    /**
     * 是否是有效的字符串（null 或 空 false）
     *
     * @param input 输入
     * @return true
     */
    public static boolean isValidString(String input) {
        return input != null && !"".equals(input);
    }
}
