/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/2 0002 10:07
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 * 提示：
 *
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 */
public class MaxProfit {
    /**
     *
     * 理解题意最重要，第一思路：回溯所有组合，得到最大值
     *      改进：既然求得是获利最大，也就是每次股票升职了，都会获利，那就是求 后一天如果比前一天股价高，就加上升值的
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        dfs(prices,0,0,0);
        return sum;
    }

    private int sum = 0;

    private void dfs( int[] prices, int index, int status,int curMoney) {
        if (index == prices.length){
            sum = Math.max(curMoney,sum);
            return;
        }
        // 不动
        dfs(prices, index + 1, status, curMoney);

        if (status == 0) {
            // 可以尝试转向 1，买
            dfs(prices, index + 1,1, curMoney - prices[index]);

        } else {
            // 此时 status == 1，可以尝试转向 0，卖
            dfs(prices, index + 1, 0, curMoney + prices[index]);
        }
    }

    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        // 卖出的利益
        int dp0 = 0;
        // 买入的利益，0 - 第一天的股价
        int dp1 = -prices[0];
        // 从第二天开始
        for (int i = 1; i < prices.length; i++) {
            // 保存变量，等会dp0要变
            int tmp = dp0;
            // 当前天的卖出利益 1. 可以选择不动，也就是上一天的卖出利益， 2. 也可以继续卖出，就是上天买入的最大利润（成本） + 当前天的股价（收获）
            dp0 = Math.max(dp0,dp1 + prices[i]);
            // 当前天买入的利益 1. 可以选择不动，还是上天的买入利益， 2. 可以继续买入 ，就是上天买入的利益 - 当前股价
            dp1 = Math.max(dp1,tmp - prices[i]);
        }
        return dp0;
    }
}
