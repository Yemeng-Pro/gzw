package 动态规划.打家劫舍和买卖股票;

public class 打家劫舍 {
    //相邻的房屋在同一晚被偷，会报警
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        // dp[i][0]表示第i个物品没有选时的最⼤⾦额
        // dp[i][1]表示第i个物品选择时的最⼤⾦额
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}
