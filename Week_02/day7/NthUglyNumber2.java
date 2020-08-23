import java.util.PriorityQueue;

/**
 * 264. 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690
 * 第二遍
 */
public class NthUglyNumber2 {
    /**
     * 动态规划
     * 思路：丑数必定为 235与其他丑数的乘积
     *      所以定义3个指针，指向235的倍数，取最小数
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0,b = 0,c = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[a] * 2,Math.min(dp[b] * 3,dp[c] * 5));
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }

    /**
     * 最小堆实现
     * 思路：将当前丑数的 2 ，3，5倍，放入最小堆，
     * @param n
     * @return
     */
    public int nthUglyNumber2(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        int count = 0;
        queue.offer(1L);
        while (true){
            long cur = queue.poll();
            if (++ count == n){
                return (int)cur;
            }
            if (!queue.contains(cur * 2)) queue.offer(cur * 2);
            if (!queue.contains(cur * 3)) queue.offer(cur * 3);
            if (!queue.contains(cur * 5)) queue.offer(cur * 5);
        }
    }
}
