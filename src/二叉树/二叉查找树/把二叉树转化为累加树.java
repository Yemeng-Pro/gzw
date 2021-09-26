package 二叉树.二叉查找树;

import 二叉树.TreeNode;
//二叉树中序遍历，交换left和rihgt的位置
public class 把二叉树转化为累加树 {
    public static void main(String[] args) {
    }
    private static int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
