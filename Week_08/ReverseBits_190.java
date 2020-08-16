
/**
 * 颠倒二进制位
 * @date 2020/8/13 20:56
 */
public class ReverseBits_190 {


    /**
     * you need treat n as an unsigned value
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
           int current = n & 1;
           result = result + (current << (31-i));
           n = n >> 1;
        }
        return result;
    }

}
