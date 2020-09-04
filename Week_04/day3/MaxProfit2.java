/**
 * @author yangxing
 * @version 1.0
 * @date 2020/9/2 0002 11:43
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class MaxProfit2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int money = 0;
        // 本质还是二重循环的升级，记录当前元素之前的（包括自己）最小值，用当前元素减去最小值获得利润
        for (int i = 0; i < prices.length; i++) {
            // 找到最小值
            min = Math.min(min,prices[i]);
            // 用当前的值减去最小值，即为利润，记录最大利润
            money = Math.max(money,prices[i] - min);
        }
        return money;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        // 卖出利润
        int dp0 = 0;
        // 买入利润
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0,dp1 + prices[i]);
            dp1 = Math.max(dp1, - prices[i]);
        }
        return dp0;
    }
}
