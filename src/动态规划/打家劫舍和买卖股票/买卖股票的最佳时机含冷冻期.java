package 动态规划.打家劫舍和买卖股票;

public class 买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        int[][] dp = new int[n][4];
        // dp[i][0]表示第i天持有股票时的利润
        // dp[i][1]表示第i天不持有股票时的利润（当天刚卖掉）
        // dp[i][2]表示第i天不持有股票时的利润（冷冻期），昨天刚卖了股票
        // dp[i][3]表示第i天不持有股票时的利润（⾮冷冻期），昨天也没持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        for (int i = 1; i < n; ++i) {
            dp[i][0] = max3(dp[i-1][0], dp[i-1][2]-prices[i], dp[i-1][3]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = dp[i-1][1];
            dp[i][3] = Math.max(dp[i-1][2], dp[i-1][3]);
        }
        return max4(dp[n-1][0], dp[n-1][1], dp[n-1][2], dp[n-1][3]);
    }

    private static int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), Math.max(b, c));
    }

    private static int max4(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
