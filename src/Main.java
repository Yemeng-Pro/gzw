import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int[][] matrix = new int[row][col];



    }

    /**
     *
     * @param matrix   恢复的图像矩阵
     * @param list     存储的灰度值信息 index0表示灰度值，index1表示对应个数
     * @param targetx  求解目标灰度值的行
     * @param targety  求解目标灰度值的列
     * @return
     */
    private static int func(int[][] matrix, LinkedList<int[]> list, int targetx, int targety) {
        //先还原图像矩阵
        while (list.peekFirst() != null) {
            int[] message = list.pollFirst();
            int number = message[0];
            int num = message[1];
            int count = 0;
//            int row = matrix.length;
            int col = matrix[0].length;
            for (int i = 0; i < num; i++) {
                int x = count/col;
                int y = count%col;
                matrix[x][y] = number;
                count++;
            }
        }
        //从还原的矩阵获取目标像素值；
        int result = 0;
        result = matrix[targetx][targety];
        return result;
    }
}
