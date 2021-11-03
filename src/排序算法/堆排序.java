package 排序算法;

import org.junit.Test;


import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-05-08 17:36
 */
public class 堆排序 {
    @Test
    public void test() {

        int[] a = {7,6, 5, 4, 3, 2, 1};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
    public void heapSort(int[] nums) {
        buildHeap(nums,nums.length);
        int n = nums.length - 1;
        while (n > 0) {
            swap(nums, 0, n);
            n--;
            adjustHeap(nums, 0, n);
        }
    }

    public void buildHeap(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length-1);
        }
    }
    //大顶堆
    public void adjustHeap(int[] nums, int begin, int length) {
        while (true) {
            int tempMax = begin;
            if(begin * 2 + 1 <= length && nums[tempMax] < nums[begin * 2 + 1])  tempMax = begin * 2 + 1;
            if(begin * 2 + 2 <= length && nums[tempMax] < nums[begin * 2 + 2]) tempMax = begin * 2 + 2;
            if(tempMax == begin) break;;
            swap(nums, tempMax, begin);
            begin = tempMax;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
