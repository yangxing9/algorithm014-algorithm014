/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/21 0021 17:47
 * 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class SearchMatrix3 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        // 从左下角开始
        int l = matrix.length - 1;
        int r = 0;
        while (l >= 0 && r < matrix[l].length){
            if (matrix[l][r] == target){
                return true;
            }else if (matrix[l][r] > target){
                l--;
            }else {
                r++;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        // 从右上角开始
        int l = 0;
        int r = matrix[0].length - 1;
        while (l < matrix.length && r >= 0){
            if (matrix[l][r] == target){
                return true;
            }else if (matrix[l][r] > target){
                r--;
            }else {
                l++;
            }
        }
        return false;
    }
}
