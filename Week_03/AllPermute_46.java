
import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 * @author ANT
 * @date 2020/7/10 22:26
 */
public class AllPermute_46 {

    private List<List<Integer>> result = new ArrayList<>();

    private int[] nums;

    private Integer len;

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null) {
            return result;
        }
        this.len = nums.length;
        this.nums = nums;
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[len];
        _permute(0, stack, used);
        return result;
    }

    private void _permute(int depth, Stack<Integer> stack, boolean[] used) {
        // terminator
        if (depth == len) {
            result.add(new ArrayList<>(stack));
            return;
        }

        // process
        for (int i = 0; i < len; i++) {
            if (used[i] == false) {
                stack.add(nums[i]);
                used[i] = true;
                // drill down
                _permute(depth+1, stack, used);
                // restore
                used[i] = false;
                stack.pop();
            }
        }

    }


}
