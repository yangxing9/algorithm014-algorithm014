import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/23 0023 14:24
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 通过次数73,136提交次数173,226
 */
public class Solve {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new Solve().solve(board);
        System.out.println(Arrays.toString(board));
    }

    /**
     * 题目类似被水包围的岛屿那一题，区别是，该题边缘的 O 是不需要改动的，连接边缘的 O 也是不需要改动
     * 那么思路就可以从边缘的 O 开始，从四条边开始 dfs，遇到 0 将元素改成 '.' 这就将不能改的 O 确认了
     * 再遍历矩阵，遇到的 O 就是没有与边缘连接的 O 了，将其改为 X ，遇到 '.'，则说明遇到 与边缘连接的 O 了，将其改回来 O 就行
     * @param board
     */
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        for (int i = 0; i < board.length; i++) {
            dfs(board,i,0);
            dfs(board,i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board,0,i);
            dfs(board,board.length - 1,i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '.') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') return;
        board[i][j] = '.';
        dfs(board,i + 1,j);
        dfs(board,i - 1,j);
        dfs(board,i,j + 1);
        dfs(board,i,j - 1);
    }

}
