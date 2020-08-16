
/**
 * 2的幂
 * @date 2020/8/16 22:02
 */
public class PowOfTwo_231 {


    /**
     * 2 的幂二进制表示只含有一个 1。
     * 清零最低位的1： X = X & (X-1)
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {

        if (n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & (x-1)) == 0;
    }

}
