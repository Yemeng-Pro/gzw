package BFS和DFS;

import java.util.Scanner;

public class Main2 {
    private static int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int length = in.nextInt();
            int[] array = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = in.nextInt();
            }
            for (int j = 0; j < length; j++) {
                dfs(array, j,0,false);
            }
            System.out.println(result);
            result = Integer.MIN_VALUE;
        }

    }

    private static void dfs(int[] arr, int curi ,int count,boolean reached){
        if (reached){
            return;
        }
        boolean newreached = false;
        count += arr[curi];
        int move2right = curi+arr[curi];
        if (move2right > arr.length) {
            result = Math.max(result, count);
            newreached = true;
            return;
        }
        if (move2right>=0 && move2right<arr.length) {
            dfs(arr, move2right, count, newreached);
        }
    }
}
