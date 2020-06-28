import java.util.stream.IntStream;

/**
 * 加一
 * @date 2020/6/23 13:37
 */
public class PlusOne_66 {

    public static void main(String[] args) {
        PlusOne_66 plusOne66 = new PlusOne_66();
        int[] array = {8,9};
        array = plusOne66.plusOne(array);
        IntStream.of(array).forEach(System.out::println);
    }

    /**
     * 加1 进位问题
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        while (len > 0) {
            if (digits[len -1] + 1 < 10) {
                digits[len -1] = digits[len -1] + 1;
                return digits;
            }
            digits[len -1] = 0;
            len--;
        }
        // 关键点，如果一直需要进位，则除了首位，其他都为0，new一个新数组即可
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


}
