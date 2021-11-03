package 二叉树.二叉树的递归;

public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        int result = dfs(root, 0);
        return result;
    }

    private static int dfs(TreeNode root, int result) {
        if (root == null) {
            return 0;
        }
        result = result * 10 + root.val;
        if (root.left == null && root.right == null) {
            return result;
        }
        return dfs(root.left, result) + dfs(root.right, result);
    }
}
