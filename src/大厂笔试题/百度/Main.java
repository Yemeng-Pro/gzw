package 大厂笔试题.百度;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < N * K; i++) {
            for (int j = 0; j < N * K; j++) {
                int x = i / K;
                int y = j / K;
                System.out.print(dp[x][y] + " ");
            }
            System.out.println();
        }
    }
}

