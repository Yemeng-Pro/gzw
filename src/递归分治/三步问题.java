package 递归分治;

public class 三步问题 {
    //递归
    private int mod = 1000000007;
    public int waysToStep(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return ((waysToStep(n-1) + waysToStep(n-2))%mod + waysToStep(n-3))%mod;
    }

    //递归+备忘录
//    private int mod = 1000000007;
    private int[] memo = new int[1000001];
    public int waysToStep2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (memo[n] != 0) return memo[n];
        memo[n] = ((waysToStep2(n-1) + waysToStep2(n-2))%mod + waysToStep2(n-3))%mod;
        return memo[n];
    }

    //dp
    public int waysToStep3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i-1]+dp[i-2])%1000000007 + dp[i-3])%1000000007;
        }
        return dp[n];
    }

    //dp优化
    public int waysToStep4(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int d = 0;
        for (int i = 4; i <= n; i++) {
            d = ((c+b)%1000000007 + a)%1000000007;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}
