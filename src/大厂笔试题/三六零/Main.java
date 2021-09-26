package 大厂笔试题.三六零;

import java.lang.invoke.LambdaConversionException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int[] res= new int[n];
        Arrays.fill(res,1);
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (array[i] > array[i + 1]) {
                res[i] = res[i] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, res[i]);
        }
        System.out.println(result);
    }

}
