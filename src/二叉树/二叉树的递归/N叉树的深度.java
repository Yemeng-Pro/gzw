package 二叉树.二叉树的递归;

import java.util.List;

public class N叉树的深度 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int childrenMaxDepth = 0;
        for (int i = 0; i < root.children.size(); ++i) {
            int depth = maxDepth(root.children.get(i));
            if (depth > childrenMaxDepth) {
                childrenMaxDepth = depth;
            }
        }
        return childrenMaxDepth+1;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};