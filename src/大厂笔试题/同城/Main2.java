package 大厂笔试题.同城;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main2 {
    public int[] rec(int[][] results) {
        // write code here
        int row = results.length;
        int col = results[0].length;
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = results[i][j];
                if (!que.contains(temp)){
                    que.add(results[i][j]);
                }
            }
        }
        int[] result = new int[que.size()];
        int i = 0;
        while (!que.isEmpty()) {
            result[i] = que.poll();
            i++;
        }
        return result;
    }

    @Test
    public void test() {
        int[][] array = {{1, 3, 2}, {4, 5, 6}, {9, 8, 7}};
        int[] result = rec(array);
        System.out.println(Arrays.toString(result));
    }
}
