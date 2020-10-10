/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/29 0029 10:41
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum().judgeSquareSum(2147483646));
    }

    /**
     * 题目：给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c 。
     * 思路: 枚举 a，判断b是否是完全平方数
     * 注意 i * i会超出 integer 范围，需要用 long
     */
    public boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double b = Math.sqrt(c - i * i);
            if (b == (int)b) return true;
        }
        return false;
    }

    private boolean isSquareNum(long num) {
        if (num < 0) return false;
        long left = 0,right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num){
                return true;
            }else if (mid * mid < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int right = (int) Math.sqrt(c);
        int left = 0;
        while (left <= right) {
            int target = left * left + right * right;
            if (target == c){
                return true;
            }else if (target < c){
                left++;
            }else {
                right--;
            }
        }
        return false;
    }

}
