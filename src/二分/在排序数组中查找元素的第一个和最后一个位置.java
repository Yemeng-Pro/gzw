package 二分;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    //查找第一个等于给定值的元素
    //查找最后一个等于给定值的元素
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int left = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid-1] != target) {         //第一个
                    left = mid;
                    break;
                } else {
                    high = mid-1;
                }
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        low = 0;
        high = nums.length-1;
        int right = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == target) {
                if (mid == nums.length-1 || nums[mid+1] != target) {  //最后一个
                    right = mid;
                    break;
                } else {
                    low = mid+1;
                }
            } else if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return new int[]{left, right};
    }
}
