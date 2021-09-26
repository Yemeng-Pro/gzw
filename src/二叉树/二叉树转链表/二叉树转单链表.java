package 二叉树.二叉树转链表;

import 二叉树.TreeNode;

public class 二叉树转单链表 {
    private TreeNode dummyHead = new TreeNode();
    private TreeNode tail = dummyHead;
    public void flatten(TreeNode root) {
        preorder(root);
    }
    private void preorder(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
// 把遍历到的节点放到结果链表中
        tail.right = root;
        tail = root;
        root.left = null;
// 左⼦树
        preorder(left);
// 右⼦树
        preorder(right);
    }
}
