package BFS和DFS;

import java.util.LinkedList;
import java.util.Queue;

public class 跳跃游戏3 {
    private boolean[] visited;
    private boolean reached = false;
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        visited = new boolean[n];
        dfs(arr, start);
        return reached;
    }
//    private void dfs(int[] arr, int curi) {
//        if (reached) return;
//        if (arr[curi]==0) {
//            reached = true;
//            return;
//        }
//
//        visited[curi] = true;
//        int move2left = curi-arr[curi];
//
//        if (move2left>=0 && move2left<arr.length
//                && visited[move2left]==false) {
//            dfs(arr, move2left);
//        }
//        int move2right = curi+arr[curi];
//        if (move2right>=0 && move2right<arr.length
//                && visited[move2right]==false) {
//            dfs(arr, move2right);
//        }
//    }

    private void dfs(int[] arr, int curi){
        if (visited[curi]||reached){
            return;
        }
        if (arr[curi] == 0) {
            reached = true;
            return;
        }
        visited[curi] = true;
        int move2left = curi-arr[curi];
        int move2right = curi+arr[curi];
        if (move2left>=0 && move2left<arr.length
                && !visited[move2left]) {
            dfs(arr, move2left);
        }
        if (move2right>=0 && move2right<arr.length
                && !visited[move2right]) {
            dfs(arr, move2right);
        }
    }
    public boolean canReach2(int[] arr, int start) {
        int len=arr.length;
        boolean[] dp=new boolean[len];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int x=queue.poll();
            if(x+arr[x]<len&&!dp[x+arr[x]]){
                dp[x+arr[x]]=true;
                queue.add(x+arr[x]);
                if(arr[x+arr[x]]==0)return true;
            }
            if(x-arr[x]>=0&&!dp[x-arr[x]]){
                dp[x-arr[x]]=true;
                queue.add(x-arr[x]);
                if(arr[x-arr[x]]==0)return true;
            }
        }
        return false;
    }


}
