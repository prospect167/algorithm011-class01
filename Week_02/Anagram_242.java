
/**
 * 有效异位字符串
 *
 * @author ANT
 * @date 2020/6/30 17:12
 */
public class Anagram_242 {

    public static void main(String[] args) {
        Anagram_242 anagram242 = new Anagram_242();
        String a = "abcdefss";
        String b = "ssfeabcd";
        System.out.println(anagram242.isAnagram(a, b));
    }

    /**
     * 忽略大小写，26个字母即可
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 一共26个字母，统计每一个字母出现的次数，一增一减
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        // 判断是否为0，否则非异位字符串
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
