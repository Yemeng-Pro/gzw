package 二叉树.反向构建二叉树;

import 二叉树.TreeNode;

public class 前序中序构建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return myBuildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    // preorder下标i,j；inorder下标p,q
    private TreeNode myBuildTree(int[] preorder, int i, int j, int[] inorder, int p, int r) {
        if (i>j) return null;
        TreeNode root = new TreeNode(preorder[i]);
        // 在中序遍历结果inorder中，查询preorder[i]所在的位置[p, q-1] q [q+1, q]
        int q = p;
        while (q <= r && inorder[q] != preorder[i]) {
            q++;
        }
        int leftTreeSize = q-p; //左右⼦树⼤⼩
        // 构建左⼦树
        TreeNode leftNode = myBuildTree(preorder, i+1, i+leftTreeSize, inorder, p, q-1);
        // 构建右⼦树
        TreeNode rightNode = myBuildTree(preorder, i+leftTreeSize+1, j, inorder, q+1, r);
        // 根据root、左⼦树、右⼦树构建树
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
