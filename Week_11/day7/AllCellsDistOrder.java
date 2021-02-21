import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/17 0017 20:17
 * 1030. 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */
public class AllCellsDistOrder {

    public static void main(String[] args) {
        int[][] res = allCellsDistOrder(2,3,1,2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] ret = new int[R * C][];
        int row = r0, col = c0;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }

    public static int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int max = R - 1 + C - 1;
        int[][] res = new int[R * C][2];
        res[0][0] = r0;
        res[0][1] = c0;
        int newIndex = 1;
        for (int i = 1; i <= max; i++) {
            for (int j = 0; j <= i; j++) {
                int first =  j;
                int second = (i - j);
                int[][] arr = new int[][]{{1,1},{1,-1},{-1,1},{-1,-1}};
                for (int k = 0; k < arr.length; k++) {
                    int f = r0 + first * arr[k][0];
                    int s = c0 +  second * arr[k][1];
                    if (f == r0 && s == c0) continue;
                    if (f >=0 && f < R && s >=0 && s < C){
                        if (newIndex == R * C) return res;
                        res[newIndex][0] = f;
                        res[newIndex++][1] = s;
                    }
                }
            }
        }
        return res;
    }

}
