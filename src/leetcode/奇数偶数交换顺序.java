package leetcode;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2021-03-26 13:47
 */
public class 奇数偶数交换顺序 {
    private boolean isOdd(int n) {
        if (n % 2 == 0) {
            return false;
        }
        return true;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int[] exchange(int[] nums) {
        int low = 0,fast = 0;
        int size = nums.length;
        while (fast < size) {
            if (isOdd(nums[fast])) {
                swap(nums, low, fast);
                low++;
            }
            fast++;
        }
        return nums;

    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        nums = exchange(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
