package 大厂笔试题.美团4_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-12 19:05
 */
public class 第一题 {
    private static int minDistance = Integer.MAX_VALUE;
    private static int res = -1;
    public static void main(String[] args) {
        //读数
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = in.nextInt();
        }
        //获取0的个数以及0的位置
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (house[i] == 0) {
                array.add(i);
            }
        }
        //分别计算每个节点到其余0的期望距离，返回一个距离最小值的点
        for (int i = 0; i < n; i++) {
            if (house[i] > k || house[i] == 0) {
                continue;
            }
            int tempmin = computDistance(array,i);
            if (tempmin < minDistance) {
                minDistance = tempmin;
                res = i;
            }
        }
        System.out.println(res);
    }

    private static int computDistance(List<Integer> array, int i) {
        int temp = 0;
        for (int num : array) {
            temp += Math.abs(num - i);
        }
        return temp;
    }
}
