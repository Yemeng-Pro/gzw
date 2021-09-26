package 二叉树.前中后序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ss {
    private class SFrame {
        public int status = 1;
        public TreeNode node = null;
        public SFrame(int status, TreeNode node) {
            this.status = status;
            this.node = node;
        }
    }
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<SFrame> stack = new Stack<>();
        TreeNode p = root;
        while (true) {
            while (p!=null) { // ⼀路向左
                stack.push(new SFrame(1, p)); // status= 1
                result.add(p.val); // 前序(status=1)
                p = p.left;
            }
// 左右⼦树都遍历完，再次访问的到这个节点时：2->3
            while (!stack.isEmpty() && stack.peek().status == 2) {
                stack.peek().status = 3;
                stack.pop();
            }
            if (stack.isEmpty()) {
                break;
            }
// 左⼦树遍历完，再次访问到这个节点时：1->2
            stack.peek().status = 2;
            p = stack.peek().node.right;
        }
        return result;
    }
}
