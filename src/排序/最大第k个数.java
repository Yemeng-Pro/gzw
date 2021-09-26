package 排序;

import org.junit.Test;

import java.util.Arrays;

public class 最大第k个数 {
    @Test
    public void test() {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 3;
        System.out.println(findKthLargest(arr,k));
        System.out.println(arr[k-1]);
//        quickSort(arr,0,6);
//        System.out.println(Arrays.toString(arr));
    }


    public int findKthLargest(int[] nums, int k) {
        findKthSmallest(nums,k-1);
        return nums[k-1];
    }

    public void findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }
    public void quickSort(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(num, left, right);
        quickSort(num, left, p - 1);
        quickSort(num, p + 1, right);
    }
    private int partition(int[] nums, int p, int r) {
        int i = p-1;
        int j = p;
        while (j < r) {
            if (nums[j] > nums[r]) {
                swap(nums, j, i+1);
                i++;
            }
            j++;
        }
        swap(nums, i+1, r);
        return i+1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
