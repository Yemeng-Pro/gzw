package 二叉树.二叉查找树;

import 二叉树.TreeNode;

public class 后继者 {

    private boolean comming = false;
    private TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root, p);
        return successor;
    }
    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        if (successor != null) return; // 提前退出条件
        if (comming == true) {
            successor = root;
            comming = false;
            return;
        }
        if (root == p) comming = true;
        inorder(root.right, p);
    }
}
