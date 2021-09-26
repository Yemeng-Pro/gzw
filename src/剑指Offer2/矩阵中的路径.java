package 剑指Offer2;

/**
 * @author shkstart
 * @create 2021-04-24 14:13
 */
public class 矩阵中的路径 {
    public boolean exist(char[][] board, String word){
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,words,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int row, int col,int k) {
        if (row < 0 || col < 0 || row >= board.length || row >= board[0].length || board[row][col] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[row][col] = ' ';
        boolean res = dfs(board, word, row + 1, col, k + 1) || dfs(board, word, row - 1, col, k + 1) ||
                dfs(board, word, row, col + 1, k + 1) || dfs(board, word, row, col - 1, k + 1);
        board[row][col] = word[k];
        return res;
    }
}
