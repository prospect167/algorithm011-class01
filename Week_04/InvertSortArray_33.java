
/**
 * 搜索旋转排序数组
 * @author ANT
 * @date 2020/7/19 14:30
 */
public class InvertSortArray_33 {

    public static void main(String[] args) {
        InvertSortArray_33 demo = new InvertSortArray_33();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(demo.search(nums, target));
    }

    /**
     * 一分为二，则必定一半是单调的，一半存在旋转位；
     * 二分查找，一定是先考虑一边
     * 如果不在，则在另外一边
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) /2;
            if ((nums[0] <= nums[mid]) && (target > nums[mid] || target < nums[0])) {
                left = mid + 1;
            } else if (target > nums[mid] && target < nums[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left == right && target == nums[left] ? left : -1;
    }




}
