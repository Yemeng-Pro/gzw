package 大厂笔试题.百度;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        int[] array = new int[N];
        Arrays.fill(array,1);
        int[] Ki = new int[Q];   //Ki表示的是移动的人数！
        for (int i = 0; i < Q; i++) {
            Ki[i] = in.nextInt();
        }
        //题目要求是等牛子哥移动到位置1才结束。
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            int K = Ki[i];//移动的人数
            int step = 0;
            //先匹配第一个到窗口的人
            if (array[0] != 0) {
                array[0] = 0;
            }else{
                int q = 0;
                while (array[q] == 0) {
                    q++;
                }
                array[q] = 0;
                step += q;
            }


            //再匹配它后面K个人
            for (int j = 0; j < K; ++j) {
                //查找第j个人走的步数
                for (int p = 0; p < N; p++) {
                    if (array[p] == 0) {
                        int q = p;
                        while (q < N && array[q] == 0) {
                            q++;
                        }
//                        if (q == N) break;
                        array[p] = 1;
                        array[q] = 0;
                        step += q - p;
                        break;
                    }
                }
            }
            result.add(step);
        }
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            }else{
                System.out.print(result.get(i)+ " ");
            }
        }
    }

}
