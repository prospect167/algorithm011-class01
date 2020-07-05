
import java.util.stream.IntStream;

/**
 * 滑动窗口最大值
 *
 * @author ANT
 * @date 2020/7/4 17:22
 */
public class SlidingWindow_239 {

    public static void main(String[] args) {
        SlidingWindow_239 slidingWindow239 = new SlidingWindow_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        IntStream.of(slidingWindow239.maxSlidingWindow(nums, k)).forEach(System.out::println);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }

        return result;
    }
}
