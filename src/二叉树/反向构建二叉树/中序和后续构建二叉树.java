package 二叉树.反向构建二叉树;

import 二叉树.TreeNode;

public class 中序和后续构建二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return myBuildTree(postorder,  0, postorder.length-1, inorder,0, inorder.length-1);
    }
    // postorder下标i,j；inorder下标p,q
    private TreeNode myBuildTree(int[] postorder, int i, int j, int[] inorder, int p, int r) {
        if (i>j) return null;
        TreeNode root = new TreeNode(postorder[j]);
        // 在中序遍历结果inorder中，查询postorder[j]所在的位置q
        // [p, q-1] q [q+1, r]
        int q = p;
        while (q <= r && inorder[q] != postorder[j]) {
            q++;
        }
        //左右⼦树⼤⼩
        int leftTreeSize = q-p;
        // 构建左⼦树
        TreeNode leftNode = myBuildTree(postorder, i, i+leftTreeSize-1, inorder, p, q-1);
        // 构建右⼦树
        TreeNode rightNode = myBuildTree(postorder, i+leftTreeSize, j-1, inorder, q+1, r);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
