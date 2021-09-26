package 二分;

import org.junit.Test;

public class 二分查找 {

    //写成 while(left < right) ，退出循环的时候有 left == right 成立，好处是不用判断应该返回 left 还是 right；
    //区间 [left..right] 划分只有以下两种情况：
    //分成 [left..mid] 和 [mid + 1..right]，分别对应 right = mid 和 left = mid + 1；
    //分成 [left..mid - 1] 和 [mid..right]，分别对应 right = mid - 1 和 left = mid，这种情况下。需要将 int mid = (left + right) / 2 改成 int mid = (left + right + 1) / 2，否则会出现死循环，这一点不用记，出现死循环的时候，把 left 和 right 的值打印出来看一下就很清楚了；
    //退出循环 left == right，如果可以确定区间 [left..right] 一定有解，直接返回 left 就可以。否则还需要对 left 这个位置单独做一次判断；
    //二分查找的循环不变量是：在区间 [left..right] 里查找目标元素。

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
