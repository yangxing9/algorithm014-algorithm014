import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 51. N皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class SolveNQueens {

    public static void main(String[] args) {
        SolveNQueens demo = new SolveNQueens();
        List<List<String>> result = demo.solveNQueens(4);
        System.out.println(result);
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append('.');
        for (int i = 0; i < n; ++i) list.add(sb.toString());
        return doSolveNQueens(n,result,list,0);
    }

    private List<List<String>> doSolveNQueens(int n, List<List<String>> result, ArrayList<String> list, int row) {
        if (row == n){
            result.add(new ArrayList<>(list));
            return result;
        }
        for (int col = 0; col < n; col++) {
            // 因为每次添加完Q后，直接进入下一层，所以同层只有一个Q
            if (!isValidQueens(row,list,col,n)) continue;
            // 将当前行列置为Q
            setChar(row,col,'Q',list);
            // 到下一行
            doSolveNQueens(n,result,list,row + 1);
            // 清理当前层状态，改成 .
            setChar(row,col,'.',list);
        }
        return result;
    }

    private boolean isValidQueens(int row, ArrayList<String> list, int col,int n) {
        // 判断上方是否有Q
        for (int i = 0; i < row; ++i) {
            if (list.get(i).charAt(col) == 'Q')
                return false;
        }
        // 判断左上方是否有Q
        for (int i = row - 1,j = col - 1;i >= 0 && j >= 0;--i,--j) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
        }
        // 判断右上方是否有Q
        for (int i = row - 1,j = col + 1;i >= 0 && j < n; --i,++j) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    private void setChar(int row, int col, char c,ArrayList<String> list) {
        StringBuilder sb = new StringBuilder(list.get(row));
        sb.setCharAt(col, c);
        list.set(row, sb.toString());
    }
}
