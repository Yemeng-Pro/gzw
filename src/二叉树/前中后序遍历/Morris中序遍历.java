package 二叉树.前中后序遍历;

import java.util.ArrayList;
import java.util.List;

public class Morris中序遍历 {
//1，判断cur是否为空，如果为空就停止遍历。
//2，如果cur不为空
//1）如果cur没有左子节点，打印cur的值，然后让cur指向他的右子节点，即
//cur=cur.right
//2）如果cur有左子节点，则从左子节点中找到最右边的结点pre。
//1))如果pre的右子节点为空，就让pre的右子节点指向cur，即pre.right=cur，
//然后cur指向他的左子节点，即cur=cur.left。
//2))如果pre的右子节点不为空，就让他指向空，即pre.right=null，然后输出cur
//节点的值，并将节点cur指向其右子节点，即cur=cur.right。
//3，重复步骤2，直到节点cur为空为止。
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
    //首先把根节点赋值给cur
        TreeNode cur = root;
    //如果cur不为空就继续遍历
        while (cur != null) {
            if (cur.left == null) {
                //如果当前节点cur的左子节点为空，就访问当前节点cur，
                //接着让当前节点cur指向他的右子节点
                res.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                //查找pre节点，注意这里有个判断就是pre的右子节点不能等于cur
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                //如果pre节点的右指针指向空，我们就让他指向当前节点cur，
                //然后当前节点cur指向他的左子节点
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    //如果pre节点的右指针不为空，那么他肯定是指向cur的,
                    //表示cur的左子节点都遍历完了，我们需要让pre的右
                    //指针指向null，目的是把树给还原，然后再访问当前节点
                    //cur，最后再让当前节点cur指向他的右子节点。
                    pre.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
             }
         return res;
    }

    
    
}
