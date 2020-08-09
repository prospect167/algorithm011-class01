
/**
 * 字典树（前缀树）
 * 忽略大小写，26个字母存储，26叉树
 * @date 2020/8/4 22:04
 */
public class Trie {

    private boolean isEnd;

    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            if (curr.next[index] == null) {
                curr.next[index] = new Trie();
            }
            curr = curr.next[index];
        }
        curr.isEnd =  true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    /**
     * 前缀搜索
     * @param word
     * @return
     */
    private Trie searchPrefix(String word) {

        Trie curr = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            curr = curr.next[chars[i] - 'a'];
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }

}
