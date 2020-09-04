/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/2 0002 17:39
 * 529. 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 *
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 *
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 *
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 */
public class UpdateBoard {

    // 定义八个方向
    int[] xarr = {-1,-1,-1,0, 0, 1,1,1};
    int[] yarr = {-1, 0, 1,-1,1,-1,0,1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        // 如果第一个为雷，改成X直接结束了
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
        }else {
            // 否则从8个方向开始递归
            dfs(board,x,y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int boom = 0;
        // 从八个方向查询可有雷
        for (int i = 0; i < 8; i++) {
            int xx = x + xarr[i];
            int yy = y + yarr[i];
            if (xx < 0 || yy < 0 || xx >= board.length || yy >= board[0].length) continue;
            if (board[xx][yy] == 'M'){
                boom++;
            }
        }
        // 如果有雷，则将当前的格子变成雷的数量
        if (boom > 0){
            board[x][y] = (char)(boom + '0');
        }else {
            // 否则改成B，代表无雷，且已经翻过了
            board[x][y] = 'B';
            // 再从八个方向递归
            for (int i = 0; i < 8; i++) {
                int xx = x + xarr[i];
                int yy = y + yarr[i];
                // 条件多加了一个，不为E的不访问，就是只访问没翻开的
                if (xx < 0 || yy < 0 || xx >= board.length || yy >= board[0].length || board[xx][yy] != 'E') continue;
                dfs(board,xx,yy);
            }
        }
    }
}
