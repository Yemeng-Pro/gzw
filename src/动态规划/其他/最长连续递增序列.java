package 动态规划.其他;

import 剑指Offer2.Solution;

import java.util.Arrays;

public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int result = 1;
        for(int i = 1;i < n;i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            result = Math.max(result,dp[i]);
        }
        return result;
    }

    //双指针
    public int findLengthOfLCIS2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

}
