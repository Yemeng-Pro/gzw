package 二叉树.路径和;



public class 二叉树的直径 {
    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        calMaxHeight(root);
        return result;
    }
    //问题转化为求左子树的直径和右子树的直径
    private int calMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calMaxHeight(root.left);
        int rightHeight = calMaxHeight(root.right);
        if (result < leftHeight + rightHeight) {
            result = leftHeight + rightHeight;
        }
        return 1 + Math.max(leftHeight, rightHeight);
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
