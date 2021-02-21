/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/12 0012 10:26
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 */
public class SortArrayByParity {

    /**
     * 双指针
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int start = 0,end = res.length - 1;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0){
                res[start++] = A[i];
            }else {
                res[end--] = A[i];
            }
        }
        return res;
    }

    /**
     * 首尾双指针优化版，不需要额外空间
     * 0 0  这种情况 头是对的，自增即可
     * 0 1  头尾都是对的，头自增，尾自减
     * 1 0  头尾都不对，交换
     * 1 1  尾对，尾自减，头不动
     */
    public int[] sortArrayByParity2(int[] A) {
        for (int start = 0,end = A.length - 1; start < end;) {
            if ((A[start] & 1) > (A[end] & 1)){
                int tmp = A[start];
                A[start++] = A[end];
                A[end--] = tmp;
            }else {
                if ((A[start] & 1) == 0){
                    start++;
                }
                if ((A[end] & 1) != 0){
                    end--;
                }
            }
        }
        return A;
    }
}
