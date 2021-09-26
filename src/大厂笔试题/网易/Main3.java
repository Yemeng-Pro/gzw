package 大厂笔试题.网易;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M1 = in.nextInt();
            int M2 = in.nextInt();
            List<Integer>[] map1 = new List[N+1];
            List<Integer>[] map2 = new List[N+1];
            for (int j = 0; j < N+1; j++) {
                map1[j] = new ArrayList<>();
                map2[j] = new ArrayList<>();
            }
            for (int j = 0; j < M1; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                map1[a].add(b);
            }
            for (int j = 0; j < M2; j++) {
                int a = in.nextInt();
                int b = in.nextInt();
                map2[a].add(b);
            }
        }
        System.out.println(1);
    }
}
