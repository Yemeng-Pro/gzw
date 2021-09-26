package 二叉树.前中后序遍历;


import java.util.ArrayList;
import java.util.List;

public class Main {

}
class Solution1 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }
    public void preorder(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}


class Solution2 {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
}
class Solution3 {
    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return result;
    }
    private void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        result.add(root.val);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

