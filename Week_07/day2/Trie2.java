/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/22 0022 10:38
 */
public class Trie2 {
    private boolean isEnd = false;
    private Trie2[] next = new Trie2[26];

    /** Initialize your data structure here. */
    public Trie2() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) node.next[word.charAt(i) - 'a'] = new Trie2();
            node = node.next[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next[word.charAt(i) - 'a'] == null) return false;
            node = node.next[word.charAt(i) - 'a'];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie2 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.next[prefix.charAt(i) - 'a'] == null) return false;
            node = node.next[prefix.charAt(i) - 'a'];
        }
        return true;
    }

}
