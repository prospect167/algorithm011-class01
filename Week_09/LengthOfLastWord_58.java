package com.prospect.leetcode.easy;

/**
 * 最后一个单词的长度
 * @author prospect
 * @create 2020/8/22 10:26 下午
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] strs = s.split(" ");
        int len = strs.length;
        return len == 0 ? 0 : strs[len-1].length();
    }

}
