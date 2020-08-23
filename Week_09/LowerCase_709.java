package com.prospect.leetcode.easy;

/**
 * 自定义小写字符串函数
 * @author prospect
 * @create 2020/8/21 4:18 下午
 */
public class LowerCase_709 {

    public String toLowerCase(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char)(chars[i]+32);
            }
        }
        return new String(chars);
    }

}
