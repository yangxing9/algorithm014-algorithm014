import java.util.Arrays;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/12 0012 10:42
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        int[] res = sortArrayByParityII.sortArrayByParityII(new int[]{1,2,4,3});
        System.out.println(Arrays.toString(res));
    }

    /**
     * 注意题意：一半偶数 一半奇数
     *  也就是可以考虑双指针，但是这里的双指针指向的是 偶数遍历 与 奇数遍历
     *  遍历奇数索引，当遇到偶数时，再遍历偶数索引，找到第一个偶数位置的奇数，交换即可
     *  因为奇偶数是一样的，所以不存在未遍历到的情况
     */
    public int[] sortArrayByParityII(int[] A) {
        int j = 0;
        for (int i = 1; i < A.length; i += 2) {
            // 奇数索引为偶数
            if ((A[i] & 1) == 0){
                // 找到偶数索引为奇数
                while (j < A.length && (A[j] & 1) == 0){
                    j += 2;
                }
                // swap
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    /**
     * 双指针，指向奇偶索引
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = 1;
        for (int k = 0; k < A.length; k++) {
            if ((A[k] & 1) == 0){
                res[i] = A[k];
                i += 2;
            }else {
                res[j] = A[k];
                j += 2;
            }
        }
        return res;
    }
}
