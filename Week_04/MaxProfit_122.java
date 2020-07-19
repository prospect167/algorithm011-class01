/**
 * 买卖股票的最佳时机 II(贪心算法）
 * @author ANT
 * @date 2020/7/14 16:21
 */
public class MaxProfit_122 {


    public static void main(String[] args) {
        MaxProfit_122 demo = new MaxProfit_122();
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(demo.maxProfit(nums));
    }

    /**
     * 寻找谷峰谷底
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int i = 0;
        int profit = 0;
        int valley = prices[0];
        int peak = prices[0];
        int len = prices.length;
        while (i < len-1) {
            while (i < len-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            while (i < len-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }

}
