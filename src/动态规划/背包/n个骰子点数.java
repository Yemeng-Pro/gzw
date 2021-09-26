package 动态规划.背包;

public class n个骰子点数 {

    public double[] twoSum(int n) {
        int[][] dp=new int[n+1][6*n+1];   //横轴为骰子数、纵轴为n个筛子的和
        double[] ans=new double[5*n+1];   //骰子点数总和情况
        double all=Math.pow(6,n);		  //骰子点数情况
        for(int i=1;i<=6;i++)
            dp[1][i]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6 && j >= k; k++) {
                    dp[i][j] += dp[i - 1][j - k];  //这里注意，j-k要大于0
                    if (i == n)
                        ans[j - i] = dp[i][j] / all;
                }
            }
        }
        return ans;
    }
}
