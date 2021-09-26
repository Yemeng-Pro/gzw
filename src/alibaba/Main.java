package alibaba;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-26 18:50
 */
//5 3
//1 1 5 3
//4 4 3
//3 5 4
//6 5 6
//7 4 10
//8 9 9
public class Main {
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//行
        int m = in.nextInt();//列
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int[][] visited = new int[n][m];
        dfs(matrix, visited, 0, x1 - 1, y1 - 2, 0, x2 - 1, y2 - 1);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }

    private static void dfs(int[][] matrix, int[][] visited, int step, int x, int y, int pre, int x2, int y2) {
        if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0) {
            return;
        }
        if (visited[x][y] == 1 || matrix[x][y] < pre) {
            return;
        }
        if (x == x2 && y == y2) {
            res = Math.min(res, step);
        }
        visited[x][y] = 1;
        dfs(matrix, visited, step + 1, x + 1, y, matrix[x][y], x2, y2);//下
        dfs(matrix, visited, step + 1, x - 1, y, matrix[x][y], x2, y2);//上
        dfs(matrix, visited, step + 1, x, y + 1, matrix[x][y], x2, y2);//右
        dfs(matrix, visited, step + 1, x, y - 1, matrix[x][y], x2, y2);//左
        visited[x][y] = 0;
    }
}
