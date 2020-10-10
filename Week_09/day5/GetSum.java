/**
 * @author yangxing
 * @version 1.0
 * @date 2020/10/9 0009 15:19
 * 371. 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class GetSum {

    public int getSum(int a, int b) {
        while (b != 0) {
            // 当进位不为0时
            // 无进位累加值
            int temp = a ^ b;

            // 进位值
            int carry = (a & b) << 1;

            // a=无进位累加值 b=进位值
            a = temp;
            b = carry;
        }
        return a;
    }

}
