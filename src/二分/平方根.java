package 二分;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 平方根 {
    public static void main(String[] args) {
        System.out.println(mySqrt(5, (float) 0.001));
        Deque<Integer> queue = new LinkedList<>();
    }
    public static float mySqrt(int x, float esp) {
        if (x < 0) return x;
        float mid, last;
        float low, up;
        low = 0;
        up = x;
        mid = (low + up) / 2;
        do {
            if (mid * mid > x) {
                up = mid;
            } else {
                low = mid;
            }
            last = mid;
            mid = (up + low) / 2;
        } while (Math.abs(mid - last) > esp);
        return mid;
    }
}
