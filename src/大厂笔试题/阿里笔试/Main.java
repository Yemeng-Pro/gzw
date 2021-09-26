package 大厂笔试题.阿里笔试;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-16 19:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] temp = new int[3];
        int n = in.nextInt();//城堡数量
        int T = in.nextInt();//总时间
        int[][] time = new int[n-1][3]; //城堡间的道路，
        int[] ai = new int[n];
        for (int i = 0; i < n; i++) {
            ai[i] = in.nextInt();
        }
        for (int i = 0; i < (n - 1); i++) {
            for (int j = 0; j < 3; j++) {
                temp[j] = in.nextInt();
            }
            time[i] = temp;
        }
    }
}
