package 二叉树.路径和;

public class 二叉树最大路径和 {
    private static int result = 0;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        left = Math.max(left, 0);
        right = Math.max(right, 0);
        int tempMax = left + right + root.val;
        result = Math.max(result, tempMax);

        int ret = root.val;
        if (root.val + left > ret) {
            ret = left + root.val;
        }
        if (root.val + right > ret) {
            ret = right + root.val;
        }
        return ret;

    }
    public int dfs2(TreeNode root) {
        if (root == null) return 0;
        int leftMaxPath = dfs(root.left);
        int rightMaxPath = dfs(root.right);
        int max = root.val;
        if (leftMaxPath > 0) max += leftMaxPath;
        if (rightMaxPath > 0) max += rightMaxPath;
        if (max > result) result = max;
        int ret = root.val;
        if (ret < leftMaxPath+root.val) ret = leftMaxPath+root.val;
        if (ret < rightMaxPath+root.val) ret = rightMaxPath+root.val;
        return ret;
    }




}
