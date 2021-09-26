package 大厂笔试题.美团4_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-04-17 22:26
 */

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//节点总数
        int m = in.nextInt();//给出了m个节点的关系
        int k = in.nextInt();//根节点编号
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Node());
        }

        for(int i = 0; i < m; i++){
            int root = in.nextInt() - 1;
            int left = in.nextInt() - 1;
            int right = in.nextInt() - 1;
            list.get(root).left = list.get(left);
            list.get(root).right = list.get(right);
        }
        for (int i = 0; i < n; i++) {
            list.get(i).val = in.nextInt();
        }
        Node root = list.get(k - 1);
        int ans = 0;
        dfs(root, 1, Integer.MAX_VALUE);
        for(Node node : list){
            if(!node.flag){
                ans += dfs1(node);
            }
        }
        System.out.println(ans);
    }

    //向左走需要计数器小于临界点，往右走需要计数器大于临界点
    //left和right表示当前计数器的可能性，处于（left，right)之间
    public static void dfs(Node node, int left, int right){
        if(node == null) return;
        if(left >= right) {
            node.flag = false;
            return;
        }
        dfs(node.left, left, Math.min(right, node.val));
        dfs(node.right,Math.max(left, node.val), right);
    }

    public static int dfs1(Node node){
        if(node == null) return 0;
        return dfs1(node.left) + dfs1(node.right) + 1;
    }

}


class Node{
    int val;
    Node left;
    Node right;
    boolean flag = true;
}