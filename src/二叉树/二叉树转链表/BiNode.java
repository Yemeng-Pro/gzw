package 二叉树.二叉树转链表;

import 二叉树.TreeNode;

public class BiNode {
    private TreeNode dummyHead = new TreeNode();
    private TreeNode tail = dummyHead;
    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return dummyHead.right;
    }
    //中序遍历
    private void inorder(TreeNode root) {
        if (root == null) return;
// 左⼦树
        inorder(root.left);
// 把遍历到的节点放到结果链表中
        tail.right = root;
        tail = root;
        root.left = null;
// 右⼦树
        inorder(root.right);
    }
}
