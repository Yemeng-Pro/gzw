package 剑指Offer2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-22 22:26
 */
public class 归并 {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int p = (i+j)/2;
        mergeSort(nums, i, p);
        mergeSort(nums, p + 1, j);
        merge(nums, i, p, j);

    }

    private static void merge(int[] nums, int i, int p, int j) {
        int left = i, right = p + 1;
        int k = 0;
        int[] temp = new int[j - i + 1];
        while (left <= p || right <= j) {
            if (left > p) {                 //代表左边的数组已经添加完，右边有剩余
                temp[k] = nums[right++];
            } else if (right > j) {
                temp[k] = nums[left++];
            } else if (nums[left] <= nums[right]) {
                temp[k] = nums[left++];
            }else{
                temp[k] = nums[right++];
            }
            k++;
        }
        int tem = i;
        for (int num : temp) {
            nums[tem] = num;
            tem++;
        }
    }
}
