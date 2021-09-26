package 动态规划.打家劫舍和买卖股票;

public class 打家劫舍_首尾相连 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        // 第0个不偷窃，偷窃1~n-1之间的房⼦
        int max1 = rob_dp(nums, 1, n-1);
        // 第0个偷窃，偷窃2~n-2之间的房⼦
        int max2 = nums[0] + rob_dp(nums, 2, n-2);
        return Math.max(max1, max2);
    }
    private int rob_dp(int[] nums, int p, int r) {
        int n = nums.length;
        // dp[i][0]表示第i个物品没有选时的最⼤⾦额
        // dp[i][1]表示第i个物品选择时的最⼤⾦额
        int[][] dp = new int[n][2];
        dp[p][0] = 0;
        dp[p][1] = nums[p];
        for (int i = p+1; i <= r; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[r][0], dp[r][1]);
    }
}
