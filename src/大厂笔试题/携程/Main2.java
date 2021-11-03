package 大厂笔试题.携程;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weight = new int[n];
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }
        int L = in.nextInt();
        int R = in.nextInt();
        boolean[] visited = new boolean[n];
        List<Integer> path = new ArrayList<>();
        func(weight, m, L, R, visited, path, 0);
        System.out.println(result);
    }

    private static int result = 0;
    private static void func(int[] weight, int m, int L, int R, boolean[] visited, List<Integer> path, int index) {
        if (path.size() == m) {
            int sum = 0;
            for (Integer num : path) {
                sum += num;
            }
            if (sum >= L && sum <= R) {
                result++;
            }
        }
        for (int i = index; i < weight.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            path.add(weight[i]);
            func(weight, m, L, R, visited, path, index + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
