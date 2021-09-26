package 二叉树.二叉查找树;

import 二叉树.TreeNode;
//借助⼆叉查找树中序遍历结果为有序序列的特点来解题
//1. 左-根-右 从⼩到⼤排列
//2. 右-根-左 从⼤到⼩排列
public class 二叉搜索树的第K大节点 {
    int count = 0;
    int result;
    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k) {
        if (root == null) return;
        inorder(root.right, k);//返回点⼀
        if (count >= k) return; // 提前终⽌递归，剪枝
        count++;
        if (count == k) {
            result = root.val;
            return; // 提前终⽌递归，剪枝
        }
        inorder(root.left, k);//返回点⼆
    }
}
