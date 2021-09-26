package 排序算法;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-05-08 16:46
 */
public class 快拍 {
    public static void main(String[] args) {


    }
    @Test
    public void test(){
        int[] a = {7,6,6,5,4, 3, 2, 1};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    public void quickSort(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(num, left, right);
        quickSort(num, left, p - 1);
        quickSort(num, p + 1, right);
    }

    private int partition(int[] num, int left, int right) {
        int part = num[right];
        int p = left;
        for (int i = left; i < right; i++) {
            if (num[i] < part) {
                swap(num, i, p);
                p++;
            }
        }
        swap(num, right, p);
        return p;
    }

//    private int partition(int[] nums, int p, int r) {
//        int i = p-1;
//        int j = p;
//        while (j < r) {
//            if (nums[j] > nums[r]) {
//                swap(nums, j, i+1);
//                i++;
//            }
//            j++;
//        }
//        swap(nums, i+1, r);
//        return i+1;
//    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
