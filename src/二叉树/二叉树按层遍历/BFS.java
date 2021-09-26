package 二叉树.二叉树按层遍历;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.RunnableScheduledFuture;

public class BFS {
    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode temp = que.poll();
            result.add(temp.val);
            if(temp.left!=null)que.add(temp.left);
            if(temp.right!=null)que.add(temp.right);
        }


        int[] res = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            res[i++] = num;
        }
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}