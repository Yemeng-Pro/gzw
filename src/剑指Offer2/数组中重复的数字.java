package 剑指Offer2;

/**
 * @author shkstart
 * @create 2021-05-12 21:59
 */
public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (i != nums[i]) {
                swap(nums,i,nums[i]);
            }
            if (nums[i] == nums[nums[i]]) return nums[i];
        }
        return -1;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
