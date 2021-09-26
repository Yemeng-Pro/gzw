package 动态规划.路径;

import java.util.List;

public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        //第i行的数组长度为i+1,i从0开始算
        //每行最两边的数据不需要判断，中间的数据需要比较
        for (int i = 1; i < n; ++i) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; ++j) {
            if (dp[n-1][j] < res) res = dp[n-1][j];
        }
        return res;
    }
}
