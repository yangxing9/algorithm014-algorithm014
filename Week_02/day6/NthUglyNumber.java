import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 */
public class NthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }

    public static int nthUglyNumber2(int n) {
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.offer(1);
        int count = 0;
        while (!queue.isEmpty()){
            //拿到的都是堆顶最小的值，所以能保证是从小到大第n个
            int num = queue.poll();
            if (++count == n){
                return num;
            }
            //添加进入所有可能的值，因为存在重复，所以需要去重
            if (!queue.contains(num * 2)) queue.offer(num * 2);
            if (!queue.contains(num * 3)) queue.offer(num * 3);
            if (!queue.contains(num * 5)) queue.offer(num * 5);
        }
        return 0;
    }

    /**
     * 思路：动态规划，只有 2，3，5分解的数，下一个丑数必然是 2，3，5与其他丑数的乘积
     * 1
     * 2*1  3*1 5*1
     * 2
     * 2*2 3*2 5*2
     * 所以可以构建三个指针，指向235的倍数
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        //第一个数为1
        dp[0] = 1;
        //三个指针
        int a = 0,b = 0,c = 0;
        //因为加入一个数了，所以i从1开始
        for (int i = 1; i < n; i++) {
            //此处 a，b，c的大小并非一直不变的，所以不能单纯的认为 * 2就是下一个
            dp[i] = Math.min(dp[a] * 2,Math.min(dp[b] * 3,dp[c] * 5));
            //如果当前丑数是 *2 得来的，那么指向2倍数的指针只增，其他同理
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}
