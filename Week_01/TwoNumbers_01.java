
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 两数之和
 * @date 2020/6/24 22:27
 */
public class TwoNumbers_01 {

    public static void main(String[] args) {
        TwoNumbers_01 twoNumbers = new TwoNumbers_01();
        int[] nums = new int[]{9,3,2, 1, 11,8, 15};
        int target = 9;
        int[] result = twoNumbers.twoSum(nums, target);
        IntStream.of(result).forEach(System.out::println);
    }
    /**
     * 两数之和，空间换时间
     * hashmap暂时存储
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 缓存起来
        Map<Integer, Integer> cache = new HashMap<>(nums.length * 2);
        // 遍历获取
        for (int i = 0; i < nums.length; i++) {
            Integer temp = cache.get(target - nums[i]);
            if (temp != null && i != temp) {
                return new int[]{temp,i};
            }
            cache.put(nums[i], i);
        }
        return null;
    }

}
