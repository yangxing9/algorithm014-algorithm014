/**
 * @author yangxing
 * @version 1.0
 * @date 2020/11/3 0003 10:26
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 示例 1：
 *
 * 输入：[2,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：[3,5,5]
 * 输出：false
 * 示例 3：
 *
 * 输入：[0,3,2,1]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        System.out.println(validMountainArray.validMountainArray(new int[]{14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3}));
    }

    public boolean validMountainArray(int[] A) {
        int maxIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[maxIndex]){
                break;
            }else {
                maxIndex = i;
            }
        }
        if (maxIndex == 0 || maxIndex == A.length - 1) return false;
        int minIndex = maxIndex;
        for (int i = maxIndex + 1; i < A.length; i++) {
            if (A[i] < A[minIndex]){
                minIndex = i;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean validMountainArray2(int[] A) {
        int l = 0,r = A.length - 1;
        while (l < A.length - 1 && A[l] < A[l + 1]){
            l++;
        }
        while (r > 0 && A[r - 1] > A[r]){
            r--;
        }
        return l > 0 && r < A.length - 1 && l == r;
    }

}
