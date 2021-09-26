package 动态规划.背包;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // 第i个硬币决策完之后，凑⾜⾦额j需要的最少硬币数dp[i][j]
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int c = 0; c <= amount/coins[0]; ++c) {
            dp[0][c*coins[0]] = c;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                int k = j/coins[i];
                for (int c = 0; c <= k; ++c) {
                    if (dp[i-1][j-c*coins[i]] != Integer.MAX_VALUE && dp[i-1][j-c*coins[i]] + c < dp[i][j]) {
                        dp[i][j] = dp[i-1][j-c*coins[i]] + c;
                    }
                }
            }
        }
        if (dp[n-1][amount] == Integer.MAX_VALUE) return -1;
        return dp[n-1][amount];
    }
}
