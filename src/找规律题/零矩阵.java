package 找规律题;

import java.util.BitSet;

public class 零矩阵 {


    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        if(r == 0) return;
        int c = matrix[0].length;

        //用两个数组来记录哪里为0
        BitSet row = new BitSet(r);
        BitSet column = new BitSet(c);
        for(int i = 0;i < r;i++){
            for(int j = 0; j < c;j++){
                if(matrix[i][j] == 0){
                    row.set(i);
                    column.set(j);
                }
            }
        }

        //置零
        for(int i = 0;i < r;i++){
            for(int j = 0; j < c;j++){
                if(row.get(i)||column.get(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
