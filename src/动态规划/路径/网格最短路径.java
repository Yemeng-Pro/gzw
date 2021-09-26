package 动态规划.路径;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 网格最短路径 {
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = 0;
        List<String[]> list = new ArrayList<>();
        int count = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] nums = line.split(" ");
            N = nums.length;
            list.add(nums);
            count++;
            if (count >= N) break;
        }
        int[][] path = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String[] nums = list.get(i);
                path[i][j] = Integer.parseInt(nums[j]);
            }
        }


        boolean[][] visited = new boolean[N][N];
        if (path[N-1][N-1] == 1) {
            System.out.println(-1);
        }else {
            dfs(0, 0, 0, path, visited);
            System.out.println(res);
        }

    }

    private static void dfs(int row, int col, int time, int[][] path, boolean[][] visited) {
        if (row < 0 || row >= path.length || col < 0 || col >= path[0].length || visited[row][col] || path[row][col] == 1) {
            return;
        }
        if (row == path.length - 1 && col == path[0].length - 1) {
            time++;
            res = Math.min(res, time);
            return;
        }
        visited[row][col] = true;
        time++;
        dfs(row - 1, col, time, path, visited);//上
        dfs(row + 1, col, time, path, visited);//下
        dfs(row, col - 1, time, path, visited);//左
        dfs(row, col + 1, time, path, visited);//右
        visited[row][col] = false;//回溯
    }
}
