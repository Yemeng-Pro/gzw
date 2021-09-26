package leetcode;

/**
 * @author shkstart
 * @create 2021-03-26 14:57
 */
public class 二叉树的镜像 {
    private void swap(TreeNode root) {
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;

    }


}
