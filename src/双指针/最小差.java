package 双指针;

import java.util.Arrays;

public class 最小差 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int n = a.length;
        int m = b.length;
        long minRet = Long.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] >= b[j]) {
                minRet = Math.min(minRet, (long)a[i]-b[j]);
                j++;
            } else {
                minRet = Math.min(minRet, (long)b[j]-a[i]);
                i++;
            }
        }
        return (int)minRet;
    }
}
