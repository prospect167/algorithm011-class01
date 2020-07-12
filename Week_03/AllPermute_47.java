
import java.util.*;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列
 * @author ANT
 * @date 2020/7/10 22:26
 */
public class AllPermute_47 {


    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;

    private Integer len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        // repeat num, first sort
        Arrays.sort(nums);
        this.nums = nums;
        this.len = nums.length;
        boolean[] used = new boolean[len];
        Deque<Integer> deque = new ArrayDeque<>(len);
        _permute(0, deque, used);
        return result;
    }

    private void _permute(int depth, Deque<Integer> stack, boolean[] used) {

        if (depth == len) {
            result.add(new ArrayList<>(stack));
            return;
        }

        // process
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            // reduce repeat
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }

            // do choice
            used[i] = true;
            stack.addLast(nums[i]);
            // drill down
            _permute(depth+1, stack, used);
            // restore
            used[i] = false;
            stack.removeLast();
        }

    }


}
