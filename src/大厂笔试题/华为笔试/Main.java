package 大厂笔试题.华为笔试;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-14 18:44
 */
public class Main {
    private static int num = 0;
    public static void main(String[] args) {
        //数据读取
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = in.nextInt();
        }
        choose(distance,0);
        System.out.println(num);

    }
    //贪心算法
    private static void choose(int[] distance,int i) {
        if (distance[i] + i >= distance.length-1) {
            num++;
            return;
        }
        int[] canChoose = new int[distance[i]];
        int maxi = 0;
        int tempmax = Integer.MIN_VALUE;
        for (int j = 1; j <= canChoose.length; j++) {
            canChoose[j-1] = distance[i + j];
            if (tempmax < distance[i + j]) {
                tempmax = distance[i + j];
                maxi = i + j;
            }
        }
        num++;
        choose(distance,maxi);
    }
}
