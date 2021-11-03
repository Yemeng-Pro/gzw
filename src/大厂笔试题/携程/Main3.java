package 大厂笔试题.携程;


import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }
        int L = in.nextInt();
        int R = in.nextInt();
        Arrays.sort(weight);
        int p1 = 0;
        int p2 = n - 1;
    }
}
