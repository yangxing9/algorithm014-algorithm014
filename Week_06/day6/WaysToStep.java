/**
 * 面试题 08.01. 三步问题
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 *  n = 1
 *  1
 *
 *  n = 2
 *  2
 *
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 */
public class WaysToStep {

    public int waysToStep(int n) {
        long one = 1;
        long two = 2;
        long tree = 4;
        if (n < 3) return n;
        if (n == 3) return (int) tree;
        long res = 0;
        for (int i = 3; i < n; i++) {
            res = (one + two + tree) % 1000000007;
            one = two;
            two = tree;
            tree = res;
        }
        return (int) res;
    }
}
