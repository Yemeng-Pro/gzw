package 动态规划.其他;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] lisToMinV = new int[n+1];
        int k = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            int len = bsearch(lisToMinV, k, nums[i]);
            if (len == -1) {
                dp[i] = 1;
            } else {
                dp[i] = len+1;
            }
            if (dp[i] > k) {
                k = dp[i];
                lisToMinV[dp[i]] = nums[i];
            } else if (lisToMinV[dp[i]] > nums[i]) {
                lisToMinV[dp[i]] = nums[i];
            }
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
    private int bsearch(int[] a, int k, int target) {
        int low = 1;
        int high = k;
        while (low <= high) {
            int mid = (low+high)/2;
            if (a[mid]<target) {
                if (mid==k || a[mid+1]>=target) {
                    return mid;
                } else {
                    low = mid+1;
                }
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
