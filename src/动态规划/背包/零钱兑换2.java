package 动态规划.背包;

public class 零钱兑换2 {
    //是计数问题：填满背包有多少种⽅法
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int c = 0; c <= amount/coins[0]; ++c) {
            dp[0][c*coins[0]] = 1;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= amount; ++j) {
                int k = j/coins[i];
                for (int c = 0; c <= k; ++c) {
                    dp[i][j] += dp[i-1][j-c*coins[i]];
                }
            }
        }
        return dp[n-1][amount];
    }
}
