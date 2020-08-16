
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @date 2020/8/16 10:52
 */
public class MergeZone_56 {
    /**
     * 先按左端点排序
     *
     * 然后判断
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        if (intervals.length < 2) {
            return intervals;
        }

        // 按区间左端点排序
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        int len = intervals.length;

        // 结果集
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] curr = intervals[i];

            // 与结果集的最后一个区间对比
            int[] temp = result.get(result.size() - 1);

            if (curr[0] > temp[1]) {
                result.add(curr);
            } else {
                // 合并
                temp[1] = Math.max(curr[1], temp[1]);
            }

        }

        return result.toArray(new int[result.size()][]);
    }

}
