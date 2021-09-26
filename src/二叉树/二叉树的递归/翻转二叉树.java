package 二叉树.二叉树的递归;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;
        return root;
    }
}
