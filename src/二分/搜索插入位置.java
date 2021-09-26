package 二分;

public class 搜索插入位置 {
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = low+(high-low)/2;
            if (nums[mid]>=target) {
                if (mid==0 || nums[mid-1]<target) {
                    return mid;
                } else {
                    high = mid-1;
                }
            } else {
                low = mid+1;
            }
        }
        return nums.length;
    }
}
