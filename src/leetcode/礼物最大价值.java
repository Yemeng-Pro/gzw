package leetcode;

/**
 * @author shkstart
 * @create 2021-03-29 17:15
 */
public class 礼物最大价值 {
    public int maxValue(int[][] grid) {
        int r = grid.length - 1;
        int c = grid[0].length - 1;
        int[][] memorial = new int[r][c];
        return findMaxvalue(grid, memorial, r, c);

    }


    private int findMaxvalue(int[][] grid, int[][] memory,int r, int c ) {
        //递归终止条件
        if (r == 0 && c == 0) {
            return grid[0][0];
        }
        if (memory[r][c] > 0) return memory[r][c];
        int left = Integer.MIN_VALUE;
        if (c > 0)
            left = findMaxvalue(grid,memory,r,c-1);
        int up =  Integer.MIN_VALUE;
        if (r > 0)
            up = findMaxvalue(grid, memory, r - 1, c);
        int cur = grid[r][c] + Math.max(left, up);
        memory[r][c] = cur;
        return cur;

    }
}
