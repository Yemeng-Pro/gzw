package 二叉树.二叉树转链表;

public class 二叉搜索树与双向链表 {
    private Node dummyHead = new Node();
    private Node tail = dummyHead;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        tail.right = dummyHead.right;
        dummyHead.right.left = tail;
        return dummyHead.right;
    }
    private void inorder(Node root) {
        if (root == null) return;
        // 左⼦树
        inorder(root.left);
        // 把遍历到的节点放到结果链表中
        root.left = tail;
        tail.right = root;
        tail = root;
        // 右⼦树
        inorder(root.right);
    }
}
class Node{
    int val;
    Node left;
    Node right;
}