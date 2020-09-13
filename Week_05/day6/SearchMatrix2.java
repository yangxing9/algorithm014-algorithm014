/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchMatrix2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int left = 0;
        int right = matrix.length - 1;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if (matrix[mid][0] > target){
                right = mid - 1;
            }else if (matrix[mid][matrix[mid].length - 1] >= target){
                break;
            }else {
                left = mid + 1;
            }
        }
        if (matrix[mid].length == 0) return false;
        if (matrix[mid][0] > target || matrix[mid][matrix[mid].length - 1] < target){
            return false;
        }
        int l = 0;
        int r = matrix[mid].length - 1;
        int m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (matrix[mid][m] == target){
                return true;
            }else if (matrix[mid][m] > target){
                r = m - 1;
            }else {
                l = m + 1;
            }
        }
        return false;
    }
}
