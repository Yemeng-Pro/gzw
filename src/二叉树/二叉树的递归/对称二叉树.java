package 二叉树.二叉树的递归;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q != null && p.val == q.val) {
            return isSymmetric(p.right, q.left) && isSymmetric(p.left, q.right);
        }
        return false;
    }
}
