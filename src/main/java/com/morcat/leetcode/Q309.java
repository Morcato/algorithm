package com.morcat.leetcode;

/**
 *
 *  Q309_最佳买卖股票时机含冷冻期
 *
 *  给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 *  @author shenzixing
 *  @since 2021-03-22
 */
public class Q309 {

    /**
     * 动态规划.
     * 本题相对于第 122题的变动只是 如果当天买了股票,后一天则不能购买股票
     * dp转移方程只需稍加变动:
     *
     *  dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
     *  dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
     *
     */
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        if (prices.length > 1) {
            dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
            dp[1][1] = Math.max(dp[0][1], -prices[1]);
        }
        for (int i = 2; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];

    }

}
