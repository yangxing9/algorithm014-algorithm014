import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/23 0023 19:49
 * 212. 单词搜索 II
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */
public class FindWords {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a','b'},{'a','a'}};
        String[] words = new String[]{"aaa","aaab","aaba","aba","baa"};
        List<String> res = new FindWords().findWords(board,words);
        res.forEach(a -> System.out.println(a));
    }

    Trie3 trie = new Trie3();
    Set<String> res = new HashSet<>();
    int[] dirRow = new int[]{1,-1,0,0};
    int[] dirCol = new int[]{0,0,1,-1};

    public List<String> findWords(char[][] board, String[] words) {
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,i,j,"",new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, String cur,boolean[][] used) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || !trie.startsWith(cur + board[i][j])) return;
        String tmp = cur;
        cur += board[i][j];
        // 关键点在于找到后不能return
        if(trie.search(cur)) res.add(cur);
        used[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(board,dirRow[k] + i,dirCol[k] + j,cur,used);
        }
        used[i][j] = false;
        cur = tmp;
    }

}
