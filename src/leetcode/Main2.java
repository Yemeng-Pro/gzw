package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-11 19:52
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        if (n < 2 * x || n > 2 * y) {
            System.out.println(-1);
        }
        Arrays.sort(score);
        int left = findm(score, x, y, n);
        System.out.println(score[left - 1]);


    }

    private static int findm(int[] array, int x, int y,int n) {
        int left = x;
        int right = y;
        while (left < right) {
            int mid = (left+right)/2;
            if (n - mid >= x && n - mid <= y) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;

    }



}
