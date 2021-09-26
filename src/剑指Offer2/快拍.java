package 剑指Offer2;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-04-22 22:10
 */
public class 快拍 {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        int i = 0;
        int j = nums.length - 1;
        quickSort(nums,i,j);
        System.out.println(Arrays.toString(nums));


    }

    public static void quickSort(int[] nums,int i,int j){
        if (i >= j) {
            return;
        }
        int q = partition(nums,i,j);
        quickSort(nums, i, q - 1);
        quickSort(nums, q+1, j);
    }

    private static int partition(int[] nums, int start, int end) {
        int part = nums[end];
        int p = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < part) {
                swap(nums, p, i);
                p++;
            }
        }
        swap(nums,p,end);
        return p;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
