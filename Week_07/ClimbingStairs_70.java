
/**
 * 爬楼梯
 * @date 2020/6/22 13:48
 */
public class ClimbingStairs_70 {

    /**
     * 动态规划，类似斐波那契数列
     * dp[n] = dp[n-1] + dp[n-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        // terminator
        if (n <= 2) {
            return n;
        }
        return climbStairs2(n -1) + climbStairs2(n - 2);
    }



}
