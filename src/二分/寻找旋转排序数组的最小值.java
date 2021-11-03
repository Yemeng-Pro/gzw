package 二分;

public class 寻找旋转排序数组的最小值 {
    //已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
    //若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
    //若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
    //
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            // 特殊处理low==high的情况
//            if (low == high) {
//                return nums[mid];
//            }
            //先处理命中情况
            if ((mid != 0 && nums[mid]<nums[mid-1])
                    ||(mid == 0 && nums[mid]<nums[high])) {
                return nums[mid];
            } else if (nums[mid]>nums[high]) { // 右循环有序
                low = mid+1;
            } else { // 右侧⾮循环有序
                high = mid-1;
            }
        }
        return -1;//永远到不了这⾥
    }


    //有重复数据的情况
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            // 特殊处理low==high的情况
            if (low == high) {
                return nums[mid];
            }
            if ((mid != 0 && nums[mid]<nums[mid-1])
                    ||(mid == 0 && nums[mid]<nums[high])) {
                return nums[mid];
            } else if (nums[mid]>nums[high]) { // 右循环有序
                low = mid+1;
            } else if (nums[mid]==nums[high]) {
                high = high-1;
            } else { // 右侧⾮循环有序
                high = mid-1;
            }
        }
        return -1;//永远到不了这
    }
}
