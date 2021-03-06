package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 八皇后 {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        backtrack(0, board, n);
        return result;
    }
    // row: 阶段
    // board: 路径，记录已经做出的决策
    // 可选列表：通过board推导出来，没有显式记录
    private void backtrack(int row, char[][] board, int n) {
    // 结束条件，得到可⾏解
        if (row == n) {
            List<String> snapshot = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                snapshot.add(new String(board[i]));
            }
            result.add(snapshot);
            return;
        }
        for (int col = 0; col < n; ++col) { //每⼀⾏都有n中放法
            if (isOk(board, n, row, col)) { //可选列表
                board[row][col] = 'Q'; //做选择，第row⾏的棋⼦放到了col列
                backtrack(row + 1, board, n); //考察下⼀⾏
                board[row][col] = '.'; //恢复选择
            }
        }
    }

    //判断row⾏column列放置是否合适
    private boolean isOk(char[][] board, int n, int row, int col) {
    // 检查列是否有冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
    // 检查右上对⻆线是否有冲突
        int i = row - 1;
        int j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
    // 检查左上对⻆线是否有冲突
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
