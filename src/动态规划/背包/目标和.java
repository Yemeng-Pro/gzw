package 动态规划.背包;

import java.util.ArrayList;
import java.util.List;

public class 目标和 {
    //所装物品总重量为target，有多少种装法
    //dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]];
    public int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) return 0;
        int n = nums.length;
        int offset = 1000;
        int m = 2000;
        int[][] dp = new int[n][m+1];
        dp[0][offset-nums[0]] += 1; // 因为nums[0]有可能为0
        dp[0][offset+nums[0]] += 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= m; ++j) {
                if (j-nums[i]>=0 && j-nums[i]<=m) {
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
                if (j+nums[i]>=0 && j+nums[i]<=m) {
                    dp[i][j] += dp[i-1][j+nums[i]];
                }
            }
        }
        return dp[n-1][S+1000];
    }


}
