package 二叉树.二叉树按层遍历;

import java.util.LinkedList;
import java.util.Queue;

public class 找到树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result = node.val;
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return result;
    }
    private static int result;
    public int findBottomLeftValue2(TreeNode root) {
        int n = find(root);
        LinkedList<TreeNode> path = new LinkedList<>();
        path.add(root);
        for(int i = 1;i<n-1;i++){
            int size = path.size();
            for (int j = 0; j < size; j++) {
                TreeNode temp = path.poll();
                if (temp.left != null) path.add(temp.left);
                if (temp.right != null) path.add(temp.right);
            }
        }

        for (TreeNode node : path) {
            if (node.left != null) {
                result = node.left.val;
                break;
            }
        }
        return result;
    }

    private int find(TreeNode root){
        return root == null?0:1+Math.max(find(root.left),find(root.right));
    }
}
