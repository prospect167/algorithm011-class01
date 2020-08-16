
/**
 *  位1的个数
 *
 * @date 2020/8/16 21:51
 */
public class HammingWeight_191 {


    /**
     * 位运算
     * X & 1 的结果判断奇偶
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {

        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            // 位运算
            if ((n & mask) == 1) {
                count++;
            }
            // 右移一位
            n = n >> 1;
        }
        return count;
    }

}
