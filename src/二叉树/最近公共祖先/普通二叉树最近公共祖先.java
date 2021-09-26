package 二叉树.最近公共祖先;

import org.omg.CORBA.IRObject;
import 二叉树.TreeNode;

public class 普通二叉树最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //向上回溯
        if (left != null && right != null) {
            // p q 一个在左，一个在右
            return root;
        }
        if (left != null) {
            // p q 都在左子树
            return left;
        }
        if (right != null) {
            // p q 都在右子树
            return right;
        }
        return null;
    }



    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, q);
        return lca;
    }
    private int traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int leftContains = traverse(root.left, p, q);
        if (lca != null) { // 提前退出
            return 2;
        }
        int rightContains = traverse(root.right, p, q);
        if (lca != null) { // 提前退出
            return 2;
        }

        int rootContains = 0;
        if (root==p || root==q) {
            rootContains = 1;
        }
        if (rootContains == 0 && leftContains == 1 && rightContains == 1) {
            lca = root;
        }
        if (rootContains == 1 && (leftContains == 1 || rightContains == 1)) {
            lca = root;
        }
        return leftContains + rightContains + rootContains;
    }
}
