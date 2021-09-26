package 二叉树.二叉树转链表;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 特定深度节点链表 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) return new ListNode[0];
        List<ListNode> result = new ArrayList<ListNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            ListNode dummyHead = new ListNode(-1);//虚拟头节点
            ListNode tail = dummyHead;
            int curLevelNum = queue.size();
            for (int i = 0; i < curLevelNum; ++i) {
                TreeNode treeNode = queue.poll();
                tail.next = new ListNode(treeNode.val);
                tail = tail.next;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            result.add(dummyHead.next);
        }
        ListNode[] resultArr = new ListNode[result.size()];

        for (int i = 0; i < result.size(); ++i) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}


class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

