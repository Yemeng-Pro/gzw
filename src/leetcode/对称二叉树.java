package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shkstart
 * @create 2021-03-26 15:14
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return (root == null) ? true : compare(root.left,root.right);
    }

    private boolean compare(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }

        return compare(L.left, R.right) && compare(L.right, R.left);
    }

    private boolean compare2(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root.left);
        que.add(root.right);
        while (!que.isEmpty()) {
            TreeNode leftNode = que.poll();
            TreeNode rightNode = que.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || (leftNode.val != rightNode.val)) {
                return false;
            }
            que.add(leftNode.left);
            que.add(rightNode.right);
            que.add(leftNode.right);
            que.add(rightNode.left);
        }
        return true;


    }


}
