/**
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
public class CoinChange {

    public static void main(String[] args) {
        CoinChange3 demo = new CoinChange3();
        int result = demo.coinChange(new int[]{1, 2, 5},11);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        return doCoinChange(new int[amount],amount,coins);
    }

    private int doCoinChange(int[] list, int amount, int[] coins) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 如果已经当前面值最小兑换个数已经有了，就不去求了
        if (list[amount - 1] != 0) return list[amount - 1];
        long minCount = Long.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            // 递归 减去当前选择硬币面值的总数 需要的硬币个数
            int result = doCoinChange(list,amount - coins[i],coins);
            // result >= 0意识是能兑换，且硬币数量小于当前的最小值，则当前兑换的硬币数量加1
            if (result >= 0 && result < minCount) minCount  = result + 1;
        }
        // 缓存兑换当前硬币面值需要的最小硬币个数
        list[amount - 1] = minCount == Long.MAX_VALUE ? -1 : (int) minCount;
        return list[amount - 1];
    }
}
