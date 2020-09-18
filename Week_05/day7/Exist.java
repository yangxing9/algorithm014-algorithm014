import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Exist {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(new Exist().exist(board,"ABCCED"));
    }

    /**
     * 核心解法：回溯
     * 和岛屿问题类似，遍历每个元素，从每个元素开始，进行dfs，当满足要求时，返回true，结束循环，否则继续
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 如果返回时true，则代表找到了，不能直接return了，可能为false
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j,int index) {
        // 边界判断，如果当前入到的元素不是目标值也要return
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        // 如果此时长度达到目标值的长度，则代表找到了
        if (index == word.length() - 1){
            return true;
        }
        // 回溯
        char tmp = board[i][j];
        board[i][j] = '.';
        // 此处的写法注意，如果分开接受每个方向，在return的时候判断，则会超时
        // 因为这样写可以使得遇到成功时，不再后续dfs
        boolean res = dfs(board,word,i + 1,j,index + 1)
                        || dfs(board,word,i - 1,j,index + 1)
                        || dfs(board,word,i,j + 1,index + 1)
                        || dfs(board,word,i,j - 1,index + 1);
        // 回溯
        board[i][j] = tmp;
        return res;
    }

}
