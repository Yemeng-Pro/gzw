package 大厂笔试题.同城;

public class Main3 {
    public boolean[] pathAvailable (int[][] matrix, int[][] starts, int[][] ends) {
        // write code here
        int n = starts.length;
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            int startx = starts[i][0];
            int starty = starts[i][1];
            int targetx = ends[i][0];
            int targety = ends[i][1];
            boolean[][] visited = new boolean[matrix.length][matrix[0].length];
            result[i] = dfs(matrix, startx, starty, targetx, targety,visited);
        }
        return result;

    }

//    private  static boolean res = false;
    private boolean dfs(int[][] matrix, int x, int y, int j, int k, boolean[][] visited) {
        if (x == j && y == k) {
            return true;
        }
        visited[x][y] = true;
        int m = matrix.length;
//        int n = matrix[0].length;
        if (x - 1 >= 0 && matrix[x - 1][y] == 1 && visited[x - 1][y] == false) {
            if (dfs(matrix,x-1,y,j,k,visited)) return true;
        }
        if (x + 1 < m && matrix[x + 1][y] == 1 && visited[x + 1][y] == false) {
            if (dfs(matrix,x+1,y,j,k,visited)) return true;
        }
        if (y - 1 >= 0 && matrix[x][y - 1] == 1 && visited[x][y - 1] == false) {
            if (dfs(matrix, x, y - 1, j, k, visited)) return true;
        }
        if (y + 1 < m && matrix[x][y + 1] == 1 && visited[x][y + 1] == false) {
            if (dfs(matrix, x, y + 1, j, k, visited)) return true;
        }
        return false;
    }
}
