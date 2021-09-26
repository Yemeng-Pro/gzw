package 纯编程题;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (target == nums[i] + nums[j]) return new int[]{i,j};
            }
        }
        return null;
    }
}
