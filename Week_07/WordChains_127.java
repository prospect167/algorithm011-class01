
import java.util.*;

/**
 * 单词接龙
 * @date 2020/8/6 23:27
 */
public class WordChains_127 {

    /**
     * 广度优先搜索（图 最短路径）
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        // 移除第一个node
        wordSet.remove(beginWord);

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();

        int step = 1;
        while (!queue.isEmpty()) {

            for (int i = queue.size(); i > 0; i--) {
                String word = queue.poll();
                char[] chars = word.toCharArray();
                // 修改每一个字符，看集合中是否存在
                for (int j = 0; j < wordLen; j++) {
                    // 字符需重置
                    char originChar = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }
                        chars[j] = k;
                        String newWord = String.valueOf(chars);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(newWord)) {
                                queue.offer(newWord);
                                visited.add(newWord);
                            }

                        }
                    }
                    chars[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }

}
