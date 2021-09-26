package 二分;

public class X的平方根 {
    //由于 x 平方根的整数部分 \textit{ans}ans 是满足 k^2 \leq xk2≤x 的最大 kk 值，因此我们可以对 kk 进行二分查找，从而得到答案。

    public int mySqrt(int x) {
        if (x == 0) return 0;
        // 从[1, x]中查找最后⼀个平⽅⼩于等于x的数
        int low = 1;
        int high = x/2+1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            long mid2 = (long)mid*mid;
            if (mid2==x) {
                return mid;
            } else if (mid2<x) {
                long mid22 = ((long)mid+1)*(mid+1);
                if (mid22 <= x) {
                    low = mid+1;
                } else {
                    return mid;
                }
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
