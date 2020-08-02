
/**
 * 矩形区域不超过 K 的最大数值和
 * @date 2020/7/31 21:19
 */
public class MaxSumSubmatrix_363 {


    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;

        for (int l = 0; l < cols; l++) {
            int[] rowSum = new int[rows];
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r];
                }
                // 最大值
                max = Math.max(max, dpMax(rowSum, k));
            }
        }

        return max;

    }

    private int dpMax(int[] rowSum, int k) {
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < rowSum.length; l++) {
            int sum = 0;
            for (int r = l; r < rowSum.length; r++) {
                sum += rowSum[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
            }
        }
        return max;
    }

}
