
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 * @author ANT
 * @date 2020/7/9 19:04
 */
public class Combine_77 {

    private List<List<Integer>> result = new ArrayList<>();


    /**
     * 递归 回溯 + 剪枝
     * 用栈来存储每一次的结果集
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        if (n < k) {
            return Collections.emptyList();
        }
        _combine(n, k , 1, new Stack<Integer>());
        return result;
    }


    public void _combine(int n, int k, int start, Stack data) {
        if (data.size() == k) {
            result.add(new ArrayList<>(data));
            return;
        }

        for (int i = start; i <= (n - (k-data.size()))+1; i++) {
            data.add(i);
            _combine(n, k, i+1, data);
            data.pop();
        }

    }
}
