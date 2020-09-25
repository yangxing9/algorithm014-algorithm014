/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/23 0023 19:50
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie3 {

    private boolean isEnd = false;
    private Trie3[] next = new Trie3[26];

    /** Initialize your data structure here. */
    public Trie3() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie3 node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) node.next[word.charAt(i) - 'a'] = new Trie3();
            node = node.next[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie3 node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) return false;
            node = node.next[word.charAt(i) - 'a'];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie3 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.next[prefix.charAt(i) - 'a'] == null) return false;
            node = node.next[prefix.charAt(i) - 'a'];
        }
        return true;
    }

}
