package 大厂笔试题.滴滴;

import jdk.nashorn.internal.runtime.FindProperty;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        findKthlarge(nums, M);
        int result = 0;

        for (int i = 0; i < M; i++) {
            result += nums[i];
        }
        System.out.println(result);
    }
    public static void findKthlarge(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k)
                break;
            if (j > k)
                h = j - 1;
            else
                l = j + 1;
        }
    }

    private static int partition(int[] num, int left, int right) {
        int part = num[right];
        int p = left;
        for (int i = left; i < right; i++) {
            if (num[i] > part) {
                swap(num, i, p);
                p++;
            }
        }
        swap(num, right, p);
        return p;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
