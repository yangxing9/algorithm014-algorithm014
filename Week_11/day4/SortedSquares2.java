/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/12 0012 13:54
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * 通过次数86,569提交次数117,6
 */
public class SortedSquares2 {

    /**
     * 思路：找到正负临界点，双指针负数倒序，正数正序
     */
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int j = 0;
        if (A[A.length - 1] <= 0){
            j = A.length - 1;
        }else{
            while (j < A.length && A[j] < 0){
                j++;
            }
        }
        int i = j - 1;
        int index = 0;
        while (i >= 0 && j < A.length){
            if (A[i] * A[i] > A[j] * A[j]){
                res[index++] = A[j] * A[j++];
            }else{
                res[index++] = A[i] * A[i--];
            }
        }
        if (i < 0 && j < A.length){
            while (j < A.length){
                res[index++] = A[j] * A[j++];
            }
        }
        if (i >= 0 && j >= A.length){
            while (i >= 0){
                res[index++] =  A[i] * A[i--];
            }
        }
        return res;
    }

    /**
     * 双指针，最大的数肯定要不是头，要不是尾，新数组从尾开始放
     *
     */
    public int[] sortedSquares2(int[] A) {
        int[] res = new int[A.length];
        int i = 0,j = A.length - 1;
        int index = res.length - 1;
        while (i <= j){
            if (A[i] * A[i] > A[j] * A[j]){
                res[index--] = A[i] * A[i++];
            }else {
                res[index--] = A[j] * A[j--];
            }
        }
        return res;
    }

}
