package 大厂笔试题.华为笔试;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-28 19:36
 */
public class Main5 {
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] delay = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                delay[i][j] = in.nextInt();
            }
        }
    }


}
