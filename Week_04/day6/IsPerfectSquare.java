/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(87));
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long left = 2,right = num / 2,mid;
        while (left <= right){
            mid  = left + (right - left) / 2;
            if (mid * mid == num) return true;
            if (mid * mid > num) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return false;
    }
}
