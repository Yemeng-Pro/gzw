package 动态规划.爬楼梯;

public class 剪绳子1 {
    // 递归转⾮递归的写法，类⽐上台阶
    // dp[i] = max（1*dp[i-1] ，2*dp[i-2] ， 3*dp[i-3] ， … ， i * dp[0]）
    public int cuttingRope(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 2;
        // dp[i]表示⻓度为i的最⼤乘积
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 2; j <= i; j++) {
                if (dp[i] < j*dp[i-j]) {
                    dp[i] = j*dp[i-j];
                }
            }
        }
        return dp[n];
    }
}
