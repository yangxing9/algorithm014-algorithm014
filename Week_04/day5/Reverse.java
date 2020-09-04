/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/4 0004 16:56
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
    }

    public static int reverse(int x) {
        int reverseNum = 0;
        while (x != 0){
            if ((reverseNum * 10) / 10 != reverseNum){
                return 0;
            }
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum;
    }

    public static int reverse2(int x) {
        long reverseNum = 0;
        while (x != 0){
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE ? 0 : (int) reverseNum;
    }
}
