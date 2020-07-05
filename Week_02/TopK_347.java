import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 前 K 个高频元素
 * @author ANT
 * @date 2020/7/4 22:47
 */
public class TopK_347 {

    public static void main(String[] args) {
        TopK_347 topK347 = new TopK_347();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        IntStream.of(topK347.topKFrequent(nums, k)).forEach(System.out::println);
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        int[] result = new int[k];

        HashMap<Integer, Integer> cache = new HashMap<>();

        for (int num : nums) {
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }

        // 优先队列，大顶堆，比较器利用好
        PriorityQueue<Integer> heap = new PriorityQueue<>((a1, a2) -> (cache.get(a2) - cache.get(a1)));
        for (int key : cache.keySet()) {
            heap.offer(key);
        }

        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

}
