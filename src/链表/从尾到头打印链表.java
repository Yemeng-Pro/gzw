package 链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Yemeng
 * @create 2020-12-09-18:54
 */
public class 从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ArrayList a = printListFromTailToHead(listNode);
        System.out.println(a);
        System.out.println(listNode);
        Stack<Integer> stack = new Stack<>();
    }
    public  static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }
}

class ListNode
{
    public int val;
    public ListNode next;
    public ListNode(){}

    public ListNode(int x, ListNode listNode) {
        this.val = x;
        this.next = listNode;
    }
    public ListNode(int x){
        this.val=x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
