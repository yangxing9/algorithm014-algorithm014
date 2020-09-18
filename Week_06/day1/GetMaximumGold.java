/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/14 0014 14:58
 * 1219. 黄金矿工
 * 你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄金数量；如果该单元格是空的，那么就是 0。
 *
 * 为了使收益最大化，矿工需要按以下规则来开采黄金：
 *
 * 每当矿工进入一个单元，就会收集该单元格中的所有黄金。
 * 矿工每次可以从当前位置向上下左右四个方向走。
 * 每个单元格只能被开采（进入）一次。
 * 不得开采（进入）黄金数目为 0 的单元格。
 * 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。
 *
 *
 * 示例 1：
 *
 * 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
 * 输出：24
 * 解释：
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * 一种收集最多黄金的路线是：9 -> 8 -> 7。
 * 示例 2：
 *
 * 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
 * 输出：28
 * 解释：
 * [[1,0,7],
 *  [2,0,6],
 *  [3,4,5],
 *  [0,3,0],
 *  [9,0,20]]
 * 一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
 */
public class GetMaximumGold {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        System.out.println(new GetMaximumGold().getMaximumGold(grid));
    }

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0){
                    int curMax = dfs(grid,i,j,0);
                    max = Math.max(max,curMax);
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int curSum) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0){
            return curSum;
        }
        int tmp = grid[i][j];
        grid[i][j] = 0;
        int r1 = dfs(grid,i + 1,j,curSum + tmp);
        int r2 = dfs(grid,i - 1,j,curSum + tmp);
        int r3 = dfs(grid,i,j + 1,curSum + tmp);
        int r4 = dfs(grid,i,j - 1,curSum + tmp);
        grid[i][j] = tmp;
        int x1 = Math.max(r1,r2);
        int x2 = Math.max(r3,r4);
        return Math.max(x1,x2);
    }
}
