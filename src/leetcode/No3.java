package leetcode;

import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-09 22:40
 */
public class No3 {
    private static int totalTime;
    private static int[][] timeMap;
    private static boolean[][] visited;
    private static int row;
    private static int col;
    private static int max;
    public static void main(String[] args) {
        //数据读入
        Scanner input = new Scanner(System.in);
        row = input.nextInt();
        col = input.nextInt();
        totalTime = input.nextInt();
        input.nextLine();
        timeMap = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                timeMap[i][j] = input.nextInt();
            }
        }
        visited = new boolean[row][col];
        dfs(0,0,timeMap[0][0]);
        //使用备忘录
        System.out.println(max);

    }

    //DFS
    private static void dfs(int i, int j, int now) {
        if (now > totalTime || i >= row || j >= col || visited[i][j]) return;
        visited[i][j] = true;
        now = now + timeMap[i][j];
        if (i == row - 1 && j == col - 1) {
            max = Math.max(max,now);
            return;
        }
        dfs(i + 1, j, now);
        dfs(i, j + 1, now);
        visited[i][j] = false;
    }

}
