
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 * @author ANT
 * @date 2020/7/2 19:54
 */
public class GroupAnagrams_49 {

    public static void main(String[] args) {
        GroupAnagrams_49 groupAnagrams49 = new GroupAnagrams_49();
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams49.groupAnagrams(array);
        result.forEach(System.out::println);
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        // 分组缓存
        HashMap<String, List<String>> cache = new HashMap<>(strs.length);
        for (String str : strs) {
            // 字符串排序
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortStr = String.valueOf(temp);

            // 异位词分组
            List<String> list = new ArrayList<>();
            if (cache.containsKey(sortStr)) {
                list = cache.get(sortStr);
            }
            list.add(str);
            cache.put(sortStr, list);
        }
        // 获取符合要求的结果集
        return new ArrayList<>(cache.values());
    }

}
