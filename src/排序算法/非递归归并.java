package 排序算法;

import java.util.Arrays;

public class 非递归归并 {
    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 8, 1, 7, 2, 9, 4};
        for (int i = 1; i <= nums.length; i *= 2) {
            for (int j = 0; j + i <= nums.length; j += i * 2) {
                //Math.min 的目的是处理 整个待排序数组为奇数的情况
                merge(nums, j, j + i - 1, Math.min(j + 2 * i - 1, nums.length - 1));
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void merge(int[] nums, int i, int p, int j) {
        int left = i;
        int right = p + 1;
        int[] temp = new int[j - i + 1];
        int k = 0;
        while (left <= p || right <= j) {
            if (left > p) {
                temp[k++] = nums[right++];
            } else if (right > j) {
                temp[k++] = nums[left++];
            } else if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        int tem = i;
        for (int num : temp) {
            nums[tem++] = num;
        }
    }
}
