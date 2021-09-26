package 二叉树.二叉树的递归;


import 二叉树.TreeNode;

public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
