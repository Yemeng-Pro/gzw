package 二叉树.二叉树的递归;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode newNode = new TreeNode(t1.val+t2.val);
        // merge左⼦树
        TreeNode leftRoot = mergeTrees(t1.left, t2.left);
        // merge右⼦树
        TreeNode rightRoot = mergeTrees(t1.right, t2.right);
        // 拼接root、左⼦树、右⼦树
        newNode.left = leftRoot;
        newNode.right = rightRoot;
        return newNode;
    }
}
