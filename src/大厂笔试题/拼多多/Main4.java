package 大厂笔试题.拼多多;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int N = in.nextInt(); //操作数
            int M = in.nextInt(); //棋子数
            int X = in.nextInt(); //行数
            int Y = in.nextInt(); //列数
            int[] array = new int[N]; //操作数组
            for (int j = 0; j < N; j++) {
                array[j] = in.nextInt();
            }
            for (int j = 0; j < M; j++) {
                int p = in.nextInt();
                int q = in.nextInt();
                int[][] matrix = new int[X + 1][Y + 1];
                int[] result = dfs(matrix, array, p, q);
                System.out.println(result[0] + " " + result[1]);
            }
        }
    }

    private static int[] dfs(int[][] matrix, int[] array, int p, int q) {
        int x = p;
        int y = q;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        for (int i = 0; i < array.length; i++) {
            int dosomething = array[i];
            if (dosomething == 1) {
                //上
                if (x > 1) {
                    x--;
                }
            } else if (dosomething == 2) {
                //左
                if (y > 1) {
                    y--;
                }
            } else if (dosomething == 3) {
                //下
                if (x < row) {
                    x++;
                }
            } else if (dosomething == 4) {
                //右
                if (y < col) {
                    y++;
                }
            }
        }
        return new int[]{x, y};
    }

}
/**
 * 2
 * 3 4 3 3
 * 1 2 3
 * 1 1
 * 1 3
 * 2 2
 * 3 1
 * 0 1 1 1
 * 1 1
 */