package JumpTable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-24 22:56
 */
public class Test {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Test model = new Test();
        List<Integer> res = model.spiralOrder(matrix);
        System.out.println(res.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int cell = matrix.length-1;
        while(left<=right&&top<=cell){
            for(int i = left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= cell; i++) {
                res.add(matrix[i][right]);
            }
            if(top != cell){
                for (int i = right - 1; i >= left; i--) {
                    res.add(matrix[cell][i]);
                }
            }
            if(left!=right){
                for (int i = cell - 1; i >= top + 1; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            cell--;
        }
        return res;
    }
}
