package 大厂笔试题.华为笔试;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-28 19:05
 */
public class Main4 {
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();
        int[][] delay = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                delay[i][j] = in.nextInt();
            }
        }
        boolean[][] visited = new boolean[M][N];
        dfs(0, 0, 0,-1, delay, visited);
        System.out.println(res);
    }

    private static void dfs(int row, int col, int time, int pre,int[][] delay, boolean[][] visited) {
        if (row < 0 || row >= delay.length || col < 0 || col >= delay[0].length || visited[row][col]) {
            return;
        }
        if (row == delay.length - 1 && col == delay[0].length - 1) {
            if (pre == delay[row][col]) time--;
            time += delay[row][col];
            res = Math.min(res, time);
            return;
        }
        visited[row][col] = true;
        if (pre == delay[row][col]) time--;
        pre = delay[row][col];
        time += delay[row][col];
        dfs(row - 1, col, time, pre, delay, visited);//上
        dfs(row + 1, col, time, pre, delay, visited);//下
        dfs(row, col - 1, time, pre, delay, visited);//左
        dfs(row, col + 1, time, pre, delay, visited);//右
        dfs(row - 1, col - 1, time, pre, delay, visited);//左上
        dfs(row + 1, col + 1, time, pre, delay, visited);//右上
        dfs(row - 1, col + 1, time, pre, delay, visited);//左下
        dfs(row + 1, col - 1, time, pre, delay, visited);//右下
        visited[row][col] = false;//回溯
    }
}
