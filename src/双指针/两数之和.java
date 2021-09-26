package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length == 0) return new int[0];
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            if (nums[i]+nums[j] == target) {
                result[0] = i;
                result[1] = j;
                i++;
                j--;
            } else if (nums[i]+nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;

    }
}
