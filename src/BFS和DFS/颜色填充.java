package BFS和DFS;

public class 颜色填充 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        dfs(image, n, m, sr, sc, image[sr][sc], newColor);
        return image;
    }
    private void dfs(int[][] image, int n, int m, int sr, int sc, int color, int newColor) {
        image[sr][sc] = newColor;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int k = 0; k < 4; ++k) {
            int newr = sr + dirs[k][0];
            int newc = sc + dirs[k][1];
            if (newr < 0 || newr >= n || newc < 0 || newc >= m || image[newr][newc] != color
                    || image[newr][newc]==newColor) {
                continue;
            }
            dfs(image, n, m, newr, newc, color, newColor);
        }
    }
}
