
import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 * （岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成）
 * @date 2020/7/5 9:28
 */
public class IslandNum_200 {

    public static void main(String[] args) {
        char[][] nums = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        IslandNum_200 demo = new IslandNum_200();
        System.out.println(demo.numIslands(nums));
    }

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int result = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 找到岛屿，递归处理其周边陆地
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }

            }
        }
        return result;
    }

    /**
     * dfs 处理
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(char[][] grid, int i, int j) {
        // terminator
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    /**
     * bfs 处理
     * @param grid
     * @param i
     * @param j
     */
    private void bfs(char[][] grid, int i, int j) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            i = curr[0];
            j = curr[1];

            if (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == '1') {
                grid[i][j] = 0;
                queue.offer(new int[] {i, j+1});
                queue.offer(new int[] {i, j-1});
                queue.offer(new int[] {i-1, j});
                queue.offer(new int[] {i+1, j});
            }

        }


    }

}
