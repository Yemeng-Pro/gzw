package 二叉树.反向构建二叉树;

import 二叉树.TreeNode;

public class 前序和后续构建二叉树 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return myBuildTree(pre,  0, pre.length-1, post,0, post.length-1);
    }
    // pre下标i,j；post下标p,r
    private TreeNode myBuildTree(int[] pre, int i, int j, int[] post, int p, int r) {
        if (i>j) return null;
        TreeNode root = new TreeNode(pre[i]);
        if (i == j) return root;//注意这⼀⾏跟前⾯⼏题不⼀样,上面一行会数组越界
        // 在post中，查询pre[i+1]所在的位置q，[p, q] [q+1, r-1] r(root)
        int q = p;
        while (q <= r-1 && post[q] != pre[i+1]) {
            q++;
        }
        //左⼦树⼤⼩
        int leftTreeSize = q-p+1;
        // 构建左⼦树
        TreeNode leftNode = myBuildTree(pre, i+1, i+leftTreeSize, post, p, q);
        // 构建右⼦树
        TreeNode rightNode = myBuildTree(pre, i+leftTreeSize+1, j, post, q+1, r-1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
