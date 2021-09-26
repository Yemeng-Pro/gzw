package 大厂笔试题.美团4_11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-12 19:05
 */
public class 第二题 {
    private static int res;
    public static void main(String[] args) {
        //数据读取
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] Mei = new int[n];
        int[] Tuan = new int[m];
        for (int i = 0; i < n; i++) {
            Mei[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            Tuan[i] = in.nextInt();
        }
        //这就暴力了？
        for (int i = 1; i < 1000; i++) {
            int scoreMei = count(Mei, i);
            int scoreTuan = count(Tuan, i);
            if (scoreTuan > scoreMei) {
                res = Math.max(res, (scoreTuan - scoreMei));
            }
        }
        System.out.println(res);


    }
    //这里用了排序加二分的方式，减少了计算分数的时间复杂度
    private static int count(int[] array, int d) {
        Arrays.sort(array);
        int l = 0,r = array.length;
        while (l < r) {
            int mid = (l+r)/2;
            if (array[mid] <= d) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int count = l + (array.length - l) * 2;
        return count;
    }
}
