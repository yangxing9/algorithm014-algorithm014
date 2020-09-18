/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/15 0015 11:22
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange3 {

    public static void main(String[] args) {
        System.out.println(new CoinChange3().coinChange(new int[]{1,2,5},11));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        return dfs(coins,amount,new int[amount]);
    }

    private int dfs(int[] coins, int amount, int[] used) {
        if (amount < 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        if (used[amount - 1] != 0){
            return used[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = dfs(coins,amount - coins[i],used);
            if (res != -1 && res < min){
                min = res + 1;
            }
        }
        used[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return used[amount - 1];
    }
}
