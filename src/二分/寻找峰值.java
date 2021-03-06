package 二分;

public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (low == high) {
                return mid;
            }
            if (mid == 0) {
                if (nums[mid]>nums[mid+1]) {
                    return mid;
                } else {
                    low = mid+1;
                }
//            } else if (mid == n-1) {
//                if (nums[mid]>nums[mid-1]) {     //实际多余了
//                    return mid;
//                } else {
//                    high = mid-1;
//                }
            } else if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
                return mid;
            } else if (nums[mid]<nums[mid+1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
