package 大厂笔试题.网易互联网;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] num = input.split(" ");
        String str = num[0];
        int m = Integer.parseInt(num[1]);
        int[][] dp = new int[str.length()][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

    }
}
