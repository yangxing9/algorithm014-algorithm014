import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/3 0003 09:53
 * 51. N 皇后
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class SolveNQueens2 {


    /**
     * N皇后问题思路： 先定义整个结构，都填充 '.' 递归每行，结束条件就是行到达最后 n， 然后在递归里遍历 列
     *                  判断当前行列，是否可以放 'Q' 判断依据，上方是否有Q，斜左上方是否有Q，斜右上方是否有Q
     *                  将当前行列的位置 改成 'Q' 递归下一层
     *                  状态修正，改为 '.'
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            list.add(sb.toString());
        }
        return doSolveNQueens2(res,list,0,n);
    }

    private List<List<String>> doSolveNQueens2(List<List<String>> res, List<String> list, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int col = 0; col < n; col++) {
            if(!isValid(list,row,col,n)) continue;
            changeCharacter(list,row,col,'Q');
            doSolveNQueens2(res,list,row + 1,n);
            changeCharacter(list,row,col,'.');
        }
        return res;
    }

    private void changeCharacter(List<String> list, int row, int col, char character) {
        StringBuilder sb = new StringBuilder(list.get(row));
        sb.setCharAt(col,character);
        list.set(row,sb.toString());
    }

    private boolean isValid(List<String> list, int row, int col,int n) {
        for (int i = 0; i < row; i++) {
            if (list.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        for (int i = row - 1,j = col - 1; i >= 0 && j >= 0; i--,j--) {
            if (list.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        for (int i = row - 1,j = col + 1; i >= 0 && j < n; i--,j++) {
            if (list.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }
}
