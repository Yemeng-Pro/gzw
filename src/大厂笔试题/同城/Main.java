package 大厂笔试题.同城;

public class Main {
    public int weight (int[] weights, int total) {
        int n = weights.length;
        // 第i个硬币决策完之后，凑⾜⾦额j需要的最少硬币数dp[i][j]
        int[][] dp = new int[n][total + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= total; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int c = 0; c <= total/weights[0]; ++c) {
            dp[0][c*weights[0]] = c;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= total; ++j) {
                int k = j/weights[i];
                for (int c = 0; c <= k; ++c) {
                    if (dp[i-1][j-c*weights[i]] != Integer.MAX_VALUE && dp[i-1][j-c*weights[i]] + c < dp[i][j]) {
                        dp[i][j] = dp[i-1][j-c*weights[i]] + c;
                    }
                }
            }
        }
        if (dp[n-1][total] == Integer.MAX_VALUE) return -1;
        return dp[n-1][total];
    }
}
