package 二叉树.二叉树的递归;

public class 判断平衡二叉树 {
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        height(root);
        return balanced;
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        if (!balanced) return 0; // 提前终⽌递归
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight-rightHeight) > 1) {
            balanced = false;
        }
        return Math.max(leftHeight, rightHeight)+1;
    }
}
