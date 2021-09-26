package 找规律题;

public class 二维数组中的查找 {
    /**
     *时间复杂度O(M+N),空间复杂度O(1)
     * @param target:目标字符
     * @param matrix:所在矩阵
     * @return true or false
     * @author gongziwei
     */
    public static boolean Find(int target, int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix.length ==0){
            return false;
        }
        int rows = matrix.length; int cols = matrix[0].length;
        int r = 0, c = cols -1;
        while (r <= rows -1 && c >= 0){
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r ++;
            else
                c --;
        }
        return false;
    }

    public static void main(String[] args) {
        int a = 16;
        int[][] b = {{1,4,7,11,15},
                     {2,5,8,12,19},
                     {3,6,9,16,22},
                     {10,13,14,17,24},
                     {18,21,23,26,30}};
        boolean c = Find(16, b);
        System.out.println(c);
    }
}
