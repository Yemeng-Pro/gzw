package 二叉树.前中后序遍历;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 争哥模板 {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(preorderTraversal(root));
    }


    //栈帧模拟，status1表示遍历左子树、status2表示右子树已经遍历、3表示左右字数都已经遍历
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
//        TreeNode p = root;
        while (true) {
            while (root!=null) { // ⼀路向左
                stack.push(new SFrame(1, root)); // status= 1
//                result.add(p.val); // 前序遍历(status=1)
                root = root.left;
            }
            // 左右⼦树都遍历完，再次访问的到这个节点时：2->3
            while (!stack.isEmpty() && stack.peek().status == 2) {
                stack.peek().status = 3;
//                result.add(stack.peek().node.val); //后序遍历
                stack.pop();
            }
            if (stack.isEmpty()) {
                break;
            }
            // 左⼦树遍历完，再次访问到这个节点时：1->2
            stack.peek().status = 2;
            result.add(stack.peek().node.val); //中序遍历
            root = stack.peek().node.right;
        }
        return result;
    }
}
