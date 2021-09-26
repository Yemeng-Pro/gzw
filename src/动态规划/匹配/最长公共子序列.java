package 动态规划.匹配;

import java.util.Arrays;

public class 最长公共子序列 {
    //如果t1[i] == t2[j]，有三种决策：（i+1, j+1）（i+1，j不变）（i不变，j+1）
    //如果t1[i] != t2[j]，有两种决策：（i+1，j不变）（i不变，j+1）

    //到达（i, j）这个状态，也就是说：开始匹配t1[i]和t2[j]了，
    //只有可能从上⼀个阶段的这⼏个状态转移过来：（i-1, j）、（i, j-1）、（i-1, j-1）
    //如果原状态是（i-1，j），那么i+1，j不变，得到（i，j）这个状态
    //如果原状态是（i，j-1），那么i不变，j+1，得到（i，j）这个状态
    //如果原状态是（i-1，j-1）&& t1[i-1] ==t2[j-1]，那么i+1,j+1，得到（i，j）这个状态


    //dp[i][j]表示⻓度为i的t1⼦串和⻓度是j的t2⼦串的最⻓公共⼦序列⻓度
    //也就是说：t1[0, i-1]和t2[0, j-1]的最⻓公共⼦序列⻓度
    //也就是说：开始匹配t1[i]和t2[j]时的最⻓公共⼦序列⻓度


    //dp[i][j] = max(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]+1) 如果t1[i-1] == t2[j-1]  这里错了，dp[i-1][j-1]+1肯定大于其他两种情况
    //dp[i][j] = max(dp[i-1][j], dp[i][j-1]) 如果t1[i-1] != t2[j-1]

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        // dp[i][j] 表示text1[0~i-1](⻓度为i⼦串)和text2[0~j-1](⻓度j的⼦串)的LCS
        int dp[][] = new int[n+1][m+1];
        for (int j = 0; j <= m; ++j) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (t1[i-1] == t2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    private int max3(int a, int b, int c) {
        int maxv = a;
        if (maxv < b) maxv = b;
        if (maxv < c) maxv = c;
        return maxv;
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int res = 0;
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        int p = 0;
        int q = 0;
        while (p < t1.length && q < t2.length) {
            if (t1[p] < t2[q]){
                p++;
            }else if(t2[q] < t1[p]){
                q++;
            }else if(t1[p] == t2[q]){
                p++;
                q++;
                res++;
            }
        }
        return res;
    }
}
