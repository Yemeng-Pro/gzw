package 剑指Offer2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-22 22:48
 */
public class 堆排序 {
    public static void main(String[] args) {
        int[] nums = {6,5, 4, 3, 2, 1};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void heapSort(int[] nums) {
        buildHeap(nums,nums.length);
        int n = nums.length-1;
        while (n > 0) {
            swap(nums,0,n);
            n--;
            adjustHeap(nums, 0, n);
        }


    }

    private static void buildHeap(int[] nums, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(nums,i,nums.length);
        }
    }

    private static void adjustHeap(int[] nums, int begin, int length) {

        while (true) {
            int maxPoint = begin;
            if (begin * 2 + 1 < length && nums[maxPoint] < nums[begin * 2 + 1]) {
                maxPoint = begin * 2 + 1;
            }
            if (begin * 2 + 2 < length && nums[maxPoint] < nums[begin * 2 + 2]) {
                maxPoint = begin * 2 + 2;
            }
            if (maxPoint == begin) break;
            swap(nums, maxPoint, begin);
            begin = maxPoint;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
