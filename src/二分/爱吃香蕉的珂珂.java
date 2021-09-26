package 二分;

public class 爱吃香蕉的珂珂 {
    //珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
    //
    //珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
    //
    //珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
    //
    //返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）
    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) return -1;
        int low = 1;
        int high = -1;
        for (int i = 0; i < piles.length; ++i) {
            if (high < piles[i]) {
                high = piles[i];
            }
        }
        // 寻找区间内满⾜条件的第⼀个值
        while (low <= high) {
            int mid = low + (high-low)/2;
            // 1. mid满⾜条件
            // 1.1 mid-1不满⾜条件 return mid
            // 1.2 mid-1也满⾜条件 high=mid-1
            // 2. mid不满⾜条件 low =mid+1
            boolean canFinish = finish(piles, mid, h);
            if (canFinish) {
                if (mid==1 || !finish(piles, mid-1, h)) {
                    return mid;
                } else {
                    high = mid-1;
                }
            } else {
                low = mid+1;
            }
        }
        return -1;
    }
    private boolean finish(int[] piles, int k, int h) {
        int cost = 0;
        for (int i = 0; i < piles.length; ++i) {
            cost += ((piles[i]-1)/k+1);
        }
        return cost <= h;
    }


}
