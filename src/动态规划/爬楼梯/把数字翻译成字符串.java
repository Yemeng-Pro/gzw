package 动态规划.爬楼梯;

import java.util.ArrayList;
import java.util.List;

public class 把数字翻译成字符串 {
    //每个阶段从1个或者和2个数字翻译
    //int dp[n+1] （n表示数字个数）dp[i]表示⻓度为i的数字序列有多少
    //种翻译⽅法。
    //到达i这个状态，那上⼀步只有可能是选了1个或2个数字翻译，也
    //就是从状态i-1, i-2转化过来。dp[i]值也由 dp[i-1]、dp[i-2]推导出来。
    //dp[i] = dp[i-1] + dp[i-2] (前提是2个数字不超过25)

    public int translateNum(int num) {
        if (num <= 9) return 1;
        // 把⼗进制数转化成数字数组
        List<Integer> digitlist = new ArrayList<>();
        while (num != 0) {
            digitlist.add(num%10);
            num /= 10;
        }
        int n = digitlist.size();
        int[] digits = new int[n];
        for (int i = 0; i < n; ++i) {
            digits[i] = digitlist.get(n-i-1);
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        // dp[i]表示digits[0~i-1](⻓度为i)转化为字⺟有多少种⽅法
        // dp[i] = dp[i-1] + dp[i-2](digits[i-2, i-1]可翻译)
        // dp[i] = dp[i-1] (digits[i-2, i-1]不可翻译)
        for (int i = 1; i <= n; ++i) { // 爬楼梯
            dp[i] = dp[i-1];
            if (i-2>=0 && isValid(digits[i-2], digits[i-1])) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
    private boolean isValid(int a, int b) {
        if (a == 1) return true;
        if (a == 2 && b >= 0 && b <= 5) return true;
        return false;
    }
}
