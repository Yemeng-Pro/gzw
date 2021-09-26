package 二叉树.最近公共祖先;

import 二叉树.TreeNode;

public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode x = root;
        while (true) {
            if (p.val < x.val && q.val < x.val) {
                x = x.left;
            } else if (p.val > x.val && q.val > x.val) {
                x = x.right;
            } else { //包含各种情况
                break;
            }
        }
        return x;
    }

    //递归实现
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;//找到了，不用再往下递归
    }
}
