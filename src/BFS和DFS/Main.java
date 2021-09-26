package BFS和DFS;

import java.util.*;

public class Main {


    public static void main(String[] args) {

    }
    private HashSet<Integer>[] adj;   //构建临节表
    private static List<List<Integer>> bfs(HashSet<Integer>[] adj, int start, int end) {
        LinkedList<Integer> que = new LinkedList<>();
        que.add(start);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); //记录路径
        while (!que.isEmpty()){
            int cur = que.pollFirst();
            HashSet<Integer> set = adj[cur];
            path.add(cur);
            //遍历当前层
            for (Integer next : set) {
                que.add(next);
    //                path.add(next);
                if (next == end) {
                    path.add(next);
                    result.add(new ArrayList<>(path));
                    path.remove(next);
                }
            }
            //若已经找到最路径,退出循环
            if (result.size() != 0) {
                break;
            }
        }
        return result;
    }
}
