package 找规律题;

import org.junit.Test;

public class 旋转图像 {
    @Test
    public void test(){
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        rotate3(matrix);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
                if (j == 2) System.out.println();
            }

        }
    }

    //1.使用额外空间
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    //2.用翻转代替旋转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 先上下翻转
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < n; ++j) {
                swap(matrix, i, j, n-i-1, j);
            }
        }
        // 再对⻆翻转（左上-右下）
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public void swap(int[][] matrix, int i,int j, int p, int q){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = temp;
    }

    //3.实际原地旋转
    public void swap4(int[][] matrix, int p1_i, int p1_j, int p2_i, int p2_j, int p3_i, int p3_j, int p4_i, int p4_j) {
        int temp = matrix[p1_i][p1_j];
        matrix[p1_i][p1_j] = matrix[p4_i][p4_j];
        matrix[p4_i][p4_j] = matrix[p3_i][p3_j];
        matrix[p3_i][p3_j] = matrix[p2_i][p2_j];
        matrix[p2_i][p2_j] = temp;
    }

    public void rotate3(int[][] matrix){
        int n = matrix.length;
        int s1_i = 0;
        int s1_j = 0;
        while (n > 1) { //n为矩阵的最外圈
            int s2_i = s1_i;
            int s2_j = s1_j + n - 1;
            int s3_i = s1_i + n - 1;
            int s3_j = s1_j + n - 1;
            int s4_i = s1_i + n - 1;
            int s4_j = s1_j;
            for (int i = 0; i < n - 1; i++) {
                int p1_i = s1_i;
                int p1_j = s1_j + i;
                int p2_i = s2_i + i;
                int p2_j = s2_j;
                int p3_i = s3_i;
                int p3_j = s3_j - i;
                int p4_i = s4_i - i;
                int p4_j = s4_j;
                swap4(matrix, p1_i, p1_j, p2_i, p2_j, p3_i, p3_j, p4_i, p4_j);
            }
            n -= 2;
            s1_i++;
            s1_j++;
        }
    }




}
