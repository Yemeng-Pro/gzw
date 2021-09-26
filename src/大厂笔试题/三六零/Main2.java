package 大厂笔试题.三六零;

import org.junit.Test;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            int sum = 1;
            while (l >= 1 && nums[l] > nums[l - 1]) {
                sum += 1;
                l--;
            }
            while (r < n - 1 && nums[r] > nums[r + 1]) {
                sum += 1;
                r++;
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }







    private static boolean isYeah(int[] array) {
        boolean result  = true;
        for (int i = 1; i < array.length-1; i++) {
            if (array[i + 1] > array[i] || array[i - 1] > array[i]) {
                continue;
            }else{
                result = false;
            }
        }
        return result;
    }


}
