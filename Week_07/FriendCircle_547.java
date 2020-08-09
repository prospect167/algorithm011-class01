
/**
 * 朋友圈
 * @date 2020/8/8 22:04
 */
public class FriendCircle_547 {

    /**
     * dfs
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {

        int[] visited = new int[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(visited, M, i);
                count++;
            }
        }

        return count;
    }


    private void dfs(int[] visited, int[][] m, int i) {

        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(visited, m, j);
            }
        }

    }

}
