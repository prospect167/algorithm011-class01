import java.util.stream.IntStream;

/**
 * 移动零
 * @date 2020/6/25 22:22
 */
public class MoveZero_283 {


    public static void main(String[] args) {
        MoveZero_283 moveZero283 = new MoveZero_283();
        int[] nums = new int[]{0,1,0,3333,2,3,0,0,1,6,8};
        moveZero283.moveZeroes(nums);
        IntStream.of(nums).forEach(System.out::println);
    }

    /**
     * 移动0
     *
     * 数组的操作考虑索引下标，减少直接移动
     * 移动非0数，剩余的都是0
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 记录非0下标
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 下标赋值
                nums[nonZeroIndex] = nums[i];
                // 必须判断下标是否相等，否则会覆盖
                if (i != nonZeroIndex) {
                    nums[i] = 0;
                }
                nonZeroIndex++;
            }
        }
    }

}
