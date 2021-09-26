package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-12 10:18
 */
public class 美团第二题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        for (int i = 1; i <= array.length; i++) {
            res += Math.abs(array[i - 1] - i);
        }
        System.out.println(res);
    }

}
