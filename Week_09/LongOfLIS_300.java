package com.prospect.leetcode.medium;

/**
 * 最长上升子序列
 * @author prospect
 * @create 2020/8/20 4:07 下午
 */
public class LongOfLIS_300 {

    /**
     * 对于类似最大子序列问题需存储一个最大值来处理
     * （dp 不一定是最优值不一定是从前一个过来）
     * dp[i] = max(dp[j]) + 1
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        // 初始化
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        // 由于是最长子序列，故事先定义一个最大值存储
        int max = 1;
        for (int i = 1; i < len; i++) {
            int temp = 0;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
