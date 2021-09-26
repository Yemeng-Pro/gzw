package 排序算法;

import org.junit.Test;


import java.util.Arrays;

/**
 * @author shkstart
 * @create 2021-05-08 17:20
 */
public class 归并排序 {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        int[] a = {5, 4, 3, 2, 1};
        mergeSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
    public void mergeSort(int[] num, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = (left + right) / 2;
        mergeSort(num, left, p);
        mergeSort(num, p + 1, right);
        merge(num, left, p, right);
    }

    public void merge(int[] nums, int i, int p, int j) {
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
