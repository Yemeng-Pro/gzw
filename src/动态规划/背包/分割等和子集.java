package 动态规划.背包;

public class 分割等和子集 {
    //01背包问题：能否装满背包
    public boolean canPartition(int[] nums) {
        //先判断总和的奇偶性
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        //再判断能不能装满sum
        boolean[][] dp = new boolean[n][sum+1];
        dp[0][0] = true;
        if (nums[0]<=sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= sum; ++j) {
                if (j-nums[i]>=0) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][sum];
    }

}
