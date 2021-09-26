package 动态规划.爬楼梯;

import java.util.List;



public class 单词拆分 {
    //每个阶段从单词列表中选择⼀个可以匹配的单词
    //int dp[n+1] dp[i]表示s[0~i-1]，也就是⻓度为i的字符串被拆分
    //假设wordlist中word1、word2、word3能跟s[0~i-1]后缀匹配，那说明到
    //达i这个状态，只有可能从i-len1，i-len2, i-len3这三个状态过来
    //dp[i] = dp[i-len1] || dp[i-len2] || dp[i-len3]

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = wordDict.size();
        // dp[i]表示⻓度为i的字符串是可拆分的
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) { //i表示⻓度
            for (String word : wordDict) { //⾛法
                int len = word.length();
                int startp = i-len;
                if (startp>=0 && s.startsWith(word, startp) && dp[i-len]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
