package 大厂笔试题.美团4_18;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-18 10:35
 */
public class Main5 {
    private static String res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayA = in.nextInt();
        int arrayB = in.nextInt();
        int k = in.nextInt();
        long sumofA = 0;
        long sumofB = 0;
        long[][] A = new long[arrayA][2];
        long[][] B = new long[arrayB][2];
        for (int i = 0; i < arrayA; i++) {
            A[i][0] = in.nextLong();
            A[i][1] = in.nextLong();
            if (A[i][1] >= k) {
                sumofA += A[i][1] * A[i][0];
            }
        }
        for (int i = 0; i < arrayB; i++) {
            B[i][0] = in.nextLong();
            B[i][1] = in.nextLong();
            if (B[i][1] >= k) {
                sumofB += B[i][1] * B[i][0];
            }
        }
        if (sumofA > sumofB) {
            res = "A";
        } else {
            res = "B";
        }
        System.out.println(sumofA + " " + sumofB);
        System.out.println(res);

    }

}
