package com.prospect.leetcode.medium;

/**
 * 最长回文字符串
 * @author prospect
 * @create 2020/8/23 10:35 下午
 */
public class LongestPalindrome_5 {

    /**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int lenA = expandAroundCenter(s, i, i);
            int lenB = expandAroundCenter(s, i, i+1);
            int len = Math.max(lenA, lenB);
            if (len > end -start) {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r-l-1;
    }

}
