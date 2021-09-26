package 大厂笔试题.拼多多;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int t = in.nextInt();
        while (t--> 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][] matrix = new int[n][];
            for (int i = 0; i < n; i++) {
                matrix[i] = new int[m];
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            if (m + n - 1 > k) {
                list.add(0);
                break;
            }
            Set<Integer> set = new HashSet<>();
            set.add(matrix[0][0]);
            int temp = dfs(0, 0, set, matrix, 0);
            list.add(temp);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static int dfs(int i, int j, Set<Integer> set, int[][] matrix, int sum) {
        int n = matrix.length;
        int m = matrix[0].length;
        int result = sum;
        if (i == n - 1 && j == m - 1) {
            return sum+1;
        }
        if (j + 1 < m && set.add(matrix[i][j + 1])) {
            result = dfs(i, j + 1, set, matrix, sum);
            set.remove(matrix[i][j + 1]);
        }
        if (i + 1 < n && set.add(matrix[i + 1][j])) {
            result = dfs(i + 1, j, set, matrix, result);
            set.remove(matrix[i + 1][j]);
        }
        return result;
    }
}
