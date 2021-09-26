package 找规律题;

import java.util.HashSet;
import java.util.Set;

public class 跳水板 {
    public int[] divingBoard(int shorter, int longer, int k) {
        // 特殊情况处理
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[] {k*shorter};
        int[] result = new int[k+1];
        // ⻓板⼦个数：0、1、2...k
        for (int i = 0; i <= k; ++i) {
            result[i] = i*longer + (k-i)*shorter;
        }
        return result;
    }
}
