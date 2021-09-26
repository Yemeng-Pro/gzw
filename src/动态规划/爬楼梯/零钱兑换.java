package 动态规划.爬楼梯;

public class 零钱兑换 {
    //背包模型和爬楼梯模型

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
                    if (dp[i-1][j-c*coins[i]] != Integer.MAX_VALUE &&
                            dp[i-1][j-c*coins[i]] + c < dp[i][j]) {
                        dp[i][j] = dp[i-1][j-c*coins[i]] + c;
                    }
                }
            }
        }
        if (dp[n-1][amount] == Integer.MAX_VALUE) return -1;
        return dp[n-1][amount];
    }


    public int coinChange2(int[] coins, int amount) {
        //每个阶段从1、2、5种选择⼀个硬币
        //int dp[amount+1] dp[i]表示凑够i元最少需要多少硬币。
        //到达i这个状态，那上⼀步只有可能是选了1、2、5，也就是从状态i-1, i-
        //2、i-5转化过来。dp[i]值也由 dp[i-1]、dp[i-2]、dp[i-5]推导出来。
        //dp[i] = min(dp[i-1] , dp[i-2], dp[i-5])+1
        int k = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0;i <= amount; ++i) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < k; ++j) {
                if (i-coins[j]>=0 && dp[i-coins[j]] != Integer.MAX_VALUE && dp[i-coins[j]]+1 < dp[i]) {
                    dp[i] = dp[i-coins[j]] + 1;
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
