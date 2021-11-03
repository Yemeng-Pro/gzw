package 大厂笔试题.滴滴;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        float[] array = new float[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextFloat();
        }
        Arrays.sort(array);
        int result = 1;
        float pre = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > pre) {
                result++;
                pre = array[i];
            }
        }
        System.out.println(result);
    }
}
