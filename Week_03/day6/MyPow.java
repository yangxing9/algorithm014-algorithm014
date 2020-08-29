/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow demo = new MyPow();
        double result = demo.myPow(2,10);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        return n < 0 ? 1 / doMyPow(x,n) : doMyPow(x,n);
    }

    private double doMyPow(double x, int n) {
        // 递归终结者
        if (n == 0) return 1.0;
        // 处理当前层
        double tmp = doMyPow(x,n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }

}
