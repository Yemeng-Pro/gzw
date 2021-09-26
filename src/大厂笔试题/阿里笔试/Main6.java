package 大厂笔试题.阿里笔试;

import java.util.Scanner;

public class Main6 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            long a = in.nextInt();
//            long b = in.nextInt();
//            System.out.println(change(a, b));
//        }
//    }
//
//    public static int change(int a, int b) {
//
//    }

//    public static int findTargetSumWays(int[] nums, int S) {
//        if (S > 100 || S < -100) return 0;
//        int n = nums.length;
//        int offset = 100;
//        int m = 200;
//        int[][] dp = new int[n][m+1];
//        dp[0][offset-nums[0]] += 1; // 因为nums[0]有可能为0
//        dp[0][offset+nums[0]] += 1;
//        for (int i = 1; i < n; ++i) {
//            for (int j = 0; j <= m; ++j) {
//                if (j-nums[i]>=0 && j-nums[i]<=m) {
//                    dp[i][j] = dp[i-1][j-nums[i]];
//                }
//                if (j+nums[i]>=0 && j+nums[i]<=m) {
//                    dp[i][j] += dp[i-1][j+nums[i]];
//                }
//            }
//        }
//        return dp[n-1][S+100];
//    }

}
