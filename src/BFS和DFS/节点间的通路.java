package BFS和DFS;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 节点间的通路 {
    private boolean[] visited;
    private HashSet<Integer>[] adj;   //构建临节表
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        visited = new boolean[n];
        adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            if (!adj[graph[i][0]].contains(graph[i][1])) {
                adj[graph[i][0]].add(graph[i][1]);
            }
        }
        return dfs(start, target);
    }
    private boolean dfs(int cur, int target) {
        if (cur == target) {
            return true;
        }
        boolean found = false;
        visited[cur] = true;
        for (Integer next : adj[cur]) {
            if (!visited[next]) {
//                found = (found || dfs(next, target));
                found = dfs(next, target);
                if (found) {
                    return found;
                }
            }
        }
        visited[cur] = false;
        return found;
    }

    //bfs
    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        //建立邻接表 list
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(n);//共有n个节点
        //首先增加n个集合
        for(int i = 0;i < n;i++){
            list.add(new ArrayList<>());
        }
        //节点的编号对应集合的位置,存放与该节点相邻的节点的编号
        for(int i = 0;i < graph.length;i++){
            list.get(graph[i][0]).add(graph[i][1]);
        }
        //队列queue存放当前节点以及访问过但尚未扩展的节点
        Queue<Integer> queue = new LinkedList<>();
        //数组visited存放是否已经访问该节点的标志
        boolean[] visited = new boolean[n];
        queue.add(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int j = 0;j < list.get(cur).size();j++){
                int node = list.get(cur).get(j);
                //如果当前节点没有访问过
                if(!visited[node]){
                    visited[node] = true;
                    if(node == target){
                        return true;
                    }
                    //将该节点放入队列中
                    queue.add(node);
                }
            }
        }
        return false;
    }


}
