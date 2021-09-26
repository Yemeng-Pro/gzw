package 二叉树.二叉树的递归;

public class 验证二叉搜索树 {
    private boolean isValid = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        dfs(root);
        return isValid;
    }
    private int[] dfs(TreeNode root) {
        if (!isValid) return null;
        int min = root.val;
        int max = root.val;
        if (root.left != null) {
            int[] leftMinMax = dfs(root.left);
            if (!isValid) return null;//提前退出条件
            if (leftMinMax[1] >= root.val) {
                isValid = false;
                return null;
            }
            min = leftMinMax[0];
        }
        if (root.right != null) {
            int[] rightMinMax = dfs(root.right);
            if (!isValid) return null;//提前退出条件
            if (rightMinMax[0] <= root.val) {
                isValid = false;
                return null;
            }
            max = rightMinMax[1];
        }
        return new int[] {min, max};
    }


    long pre = Long.MIN_VALUE; //中序遍历的方式
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }

}




