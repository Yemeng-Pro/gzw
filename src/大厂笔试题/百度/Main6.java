package 大厂笔试题.百度;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] pre = new int[K];
        for (int i = 0; i < K; i++) {
            pre[i] = N * (i+1);
            String value = String.valueOf(pre[i]);
            StringBuilder sb = new StringBuilder(value);
            sb.reverse();
            pre[i] = Integer.parseInt(sb.toString());
        }
        Arrays.sort(pre);

        System.out.println(pre[K-1]);
    }

}
