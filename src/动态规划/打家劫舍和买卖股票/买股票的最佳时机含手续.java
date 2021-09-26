package 动态规划.打家劫舍和买卖股票;

public class 买股票的最佳时机含手续 {


    //每天有两种状态：持有股票、不持有股票。
    //dp[i][0]表示第i天持有股票，赚到的最大利润
    //dp[i][1]表示第i天不持有股票，赚到的最大利润
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0]; // 第i天后持有股票，⼿⾥利润的最⼤值
        dp[0][1] = 0; // 第i天后不持有股票，⼿⾥利润的最⼤值
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i]-fee, dp[i-1][1]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
