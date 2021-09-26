package leetcode;


import org.junit.Test;

import java.util.ArrayList;

/**
 * @author shkstart
 * @create 2021-03-25 9:28
 */
public class 从尾到头打印链表 {
    public ArrayList<ListNode> reversePrint(ListNode head) {
        ListNode listNode = new ListNode(-1);
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = listNode.next;
            listNode.next = head;
            head = next;
        }

        ArrayList<ListNode> objects = new ArrayList<>();
        listNode = listNode.next;
        while (listNode != null) {
            objects.add(listNode);
            listNode = listNode.next;
        }
        return objects;



    }


    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ArrayList<ListNode> sb = reversePrint(head);

        for (ListNode node:
             sb) {
            System.out.println(node);
        }



    }

}

