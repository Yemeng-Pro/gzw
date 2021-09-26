package 大厂笔试题.拼多多;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int sum = in.nextInt();
        while (sum-- > 0) {
            int N = in.nextInt(); //操作数
            int M = in.nextInt(); //棋子数
            int X = in.nextInt(); //行数
            int Y = in.nextInt(); //列数
            int[] array = new int[N];
            int[][] matrix = new int[M][];
            for (int j = 0; j < N; j++) {
                array[j] = in.nextInt();
            }
            for (int i = 0; i < M; i++) {
                matrix[i] = new int[2];
                matrix[i][0] = in.nextInt();
                matrix[i][1] = in.nextInt();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    switch (array[i]) {
                        case (1):
                            if (matrix[j][0] > 1) {
                                matrix[j][0]--;
                                break;
                            }
                        case (2):
                            if (matrix[j][1] > 1) {
                                matrix[j][1]--;
                                break;
                            }
                        case (3):
                            if (matrix[j][0] < X) {
                                matrix[j][0]++;
                                break;
                            }
                        case (4):
                            if (matrix[j][1] < Y) {
                                matrix[j][1]++;
                                break;
                            }
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                list.add(matrix[i][0]);
                list.add(matrix[i][1]);
            }
        }
        for (int i = 0; i < list.size() / 2; i++) {
            System.out.println(list.get(2 * i) + " " + list.get(2 * i + 1));
        }
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