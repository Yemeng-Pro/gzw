package 大厂笔试题.腾讯;

import jdk.nashorn.internal.ir.FunctionCall;
import org.junit.Test;

public class Main3 {
    @Test
    public void test() {
        System.out.println(minM(10,10));
    }


    public long minM (int n, int k) {
        long m = 0;
        while (true) {
            if (func(m, k) < n) {
                m += 3;
            } else {
                break;
            }
        }
        if (func(m - 2, k) >= n) {
            return m - 2;
        } else if (func(m - 1, k) >= n) {
            return m - 1;
        } else {
            return m;
        }
    }

    private long func(long n, int k) {
        long digit = 1;
        int low = 0;
        long high = n / k;
        long cur = n % k;
        long res = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high + low +1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % k;
            high /= k;
            digit *= k;
        }
        return res;
    }
}
