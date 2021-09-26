package 链表;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        ListNode p = head;
        int count = 1;
        while (p != null) {
            ListNode tmp = p.next;
            if (count % 2 == 1) { // 奇数
                p.next = null;
                oddTail.next = p;
                oddTail = p;
            } else { // 偶数
                p.next = null;
                evenTail.next = p;
                evenTail = p;
            }
            count++;
            p = tmp;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
    public ListNode oddEvenList1(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode podd = odd;
        ListNode peven = even;
        while (podd.next != null && podd.next.next != null) {
            podd.next = podd.next.next;
            podd = podd.next;
            peven.next = peven.next.next;
            peven = peven.next;
        }
        podd.next = even;
        return odd;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        head.next =  a1;
        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;

        ListNode result = oddEvenList(head);
        ListNode p = result;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }


    }
}
