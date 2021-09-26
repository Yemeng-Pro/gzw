package 纯编程题;

public class 删除排序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[res]) {
                nums[++res] = nums[i];
            }
        }
        return res + 1;
    }
}
