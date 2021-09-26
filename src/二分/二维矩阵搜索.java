package 二分;

public class 二维矩阵搜索 {
    //找规律做法O(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int rows = matrix.length, cols = matrix[0].length;
        int r = 0, c = cols - 1; // 从右上角开始
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c])
                return true;
            else if (target > matrix[r][c])
                r++;
            else
                c--;
        }
        return false;
    }


    //二分做法，转化为一维数组
    public boolean searchMatrix2(int[][] matrix, int target) {
        int h = matrix.length;
        int w = matrix[0].length;
        int left = 0, right = h * w - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = matrix[mid/w][mid%w];
            if (target == midValue) {
                return true;
            } else if (target < midValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
