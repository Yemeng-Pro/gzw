package 大厂笔试题.jingdong;

import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        Arrays.sort(array);
        int result = 1;
        int pre = array[0];
        for (int i = 1; i < n; i++) {
            int temp = array[i] - pre;
            if (temp > x) {
                if (temp > (k + 1) * x || k == 0) {
                    result++;
                }else{
                    k -= (temp+1)/x;
                }
            }
            pre = array[i];
        }
        System.out.println(result);
    }
}
