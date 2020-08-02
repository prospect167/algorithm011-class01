
/**
 * 最小路径和
 * @date 2020/7/27 23:04
 */
public class MinPath_64 {

    /**
     * 当 i = 0; dp[0][j] = dp[0][j-1] + grid[0][j]
     * 当 j = 0; dp[i][0] = dp[i-1][0] + grid[i][0];
     * 其他，    dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        // 列
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        // 行
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // main
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[rows-1][cols-1];

    }

}
