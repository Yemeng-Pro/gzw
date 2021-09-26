package 动态规划.爬楼梯;

import 剑指Offer2.Solution;

public class 零钱兑换2 {
    public int coinChange2(int[] coins, int amount) {
        //每个阶段从1、2、5种选择⼀个硬币
        //int dp[amount+1] dp[i]表示凑够i元有多少种⽅法。
        //到达i这个状态，那上⼀步只有可能是选了1、2、5，也就是从状态i-1, i-
        //2、i-5转化过来。dp[i]值也由 dp[i-1]、dp[i-2]、dp[i-5]推导出来。
        //dp[i] = dp[i-1] + dp[i-2] + dp[i-5]
        int k = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < k; ++j) {
                if(i-coins[j] >= 0)
                    dp[i] += dp[i-coins[j]];
            }
        }
        return dp[amount];
    }
    //上面的代码是错误的，该代码计算的结果是 排列数，而不是组合数，也就是代码会把 1,2和 2,1 当做两种情况
    //因为我们这里定义的子问题是，必须选择第k个硬币时，凑成金额i的方案。如果交换了，我们的子问题就变了，那就是对于金额 i, 我们选择硬币的方案。
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
