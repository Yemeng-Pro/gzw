package 大厂笔试题.拼多多;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = in.nextInt();
        }
        int[] result = new int[n];
        //初始化第一个人
        result[n - 1] = input[n - 1] + 1;
        int[] array = new int[n+1];
        array[result[n-1]] = 1;

        //求人数
        for (int i = n - 2; i >= 0; i--) {
            int nums = input[i];
//            int index = 0;
            //遍历array数组
            for (int j = 1; j <= n; j++) {
                if (nums == 0 && array[j] == 0) {
                    array[j] = 1;
                    result[i] = j;
                    break;
                } else if (nums > 0 && array[j] == 0) {
                    nums--;
                }

            }
        }
//        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + " ");
            }
        }

    }


}
