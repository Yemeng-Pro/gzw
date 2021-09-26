package 动态规划.路径;

import org.junit.Test;

import java.awt.print.PrinterAbortException;

public class 最小路径和 {
    @Test
    public void test() {
        int[][] matrix = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(matrix));
    }
    //回溯
    private static int res = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dfs(grid,0,0,0);
        return res;
    }

    private static void dfs(int[][] grid,int m,int n,int sum){
        if (m >= grid.length || n >= grid[0].length) {
            return;
        }
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            sum += grid[m][n];
            res = Math.min(sum, res);
        }
        sum += grid[m][n];
        dfs(grid, m, n + 1, sum);
        dfs(grid, m + 1, n, sum);
    }

    //动态规划，dp[i][j]=min(dp[i-1][j]+dp[i][j-1])+grid[i][j]
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int len = 0;
        for (int i = 0; i < m; ++i) {
            len += grid[i][0];
            dp[i][0] = len;
        }
        len = 0;
        for (int j = 0; j < n; ++j) {
            len += grid[0][j];
            dp[0][j] = len;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }



}
