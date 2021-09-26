package 动态规划.匹配;

public class 编辑距离 {

    //如果t1[i] == t2[j]，有三种决策：（i+1, j+1）（i+1，j不变）（i不变，j+1）
    //如果t1[i] != t2[j]，有两种决策：1：（i+1，j+1）      2：（i+1，j不变）（i不变，j+1）
    //到达（i, j）这个状态，也就是说：开始匹配t1[i]和t2[j]了，

    //只有可能从上⼀个阶段的这⼏个状态转移过来：（i-1, j）、（i, j-1）、（i-1, j-1）
    //如果原状态是（i-1，j），那么i+1，j不变，得到（i，j）这个状态
    //如果原状态是（i，j-1），那么i不变，j+1，得到（i，j）这个状态
    //如果原状态是（i-1，j-1）&& t1[i] ==t2[j-1]，那么i+1,j+1，得到（i，j）这个状态
    //如果原状态是（i-1，j-1）&& t1[i] !=t2[j-1]，那么i+1,j+1，得到（i，j）这个状态
    //dp[i][j]表示⻓度为i的t1⼦串和⻓度是j的t2⼦串的编辑距离
    //也就是说：t1[0, i-1]和t2[0, j-1]的编辑距离
    //也就是说：开始匹配t1[i]和t2[j]时的编辑距离
    //那么：
    //dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]) 如果t1[i-1] == t2[j-1]
    //dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1) 如果t1[i-1] != t2[j-1]

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        // dp[i][j]表示w1[0~i-1](⻓度为i⼦串)和w2[0~j-1](⻓度为j的⼦串)的最⼩编辑距离
        int[][] dp = new int[n+1][m+1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w1[i-1] == w2[j-1]) {
                    dp[i][j] = min3(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]);
                } else {
                    dp[i][j] = min3(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+1);
                }
            }
        }
        return dp[n][m];
    }
    private int min3(int n1, int n2, int n3) {
        return Math.min(n1, Math.min(n2, n3));
    }
}
