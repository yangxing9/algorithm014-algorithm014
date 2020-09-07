/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/7 0007 15:22
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
public class IsPerfectSquare2 {

    public boolean isPerfectSquare(int num) {
        long left = 1,right = num,mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            }else if (mid * mid < num) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

}
