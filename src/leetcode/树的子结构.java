package leetcode;



/**
 * @author shkstart
 * @create 2021-03-26 14:33
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return hasSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);


    }

    private boolean hasSubStructure(TreeNode root1, TreeNode root2) {
        if (root1.val != root2.val) {
            return false;
        }
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        return hasSubStructure(root1.left,root2.left) || hasSubStructure(root1.right,root1.right);
    }
}
