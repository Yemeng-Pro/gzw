package 递归分治;

import java.util.HashMap;
import java.util.Map;

public class 青蛙跳台阶 {
    //备忘录
    private int mod = 1000000007;
    private Map<Integer, Integer> memo = new HashMap<>();
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ret = (numWays(n-1)+numWays(n-2))%mod;
        memo.put(n, ret);
        return ret;
    }


    //dp
    public int JumpFloor(int n) {
        if (n <= 2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for (int i = 3; i < n; i++) {
            result = pre2 + pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }
}
