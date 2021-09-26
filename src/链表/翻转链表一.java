package 链表;

import leetcode.ListNode;

/**
 * @author shkstart
 * @create 2021-05-21 20:36
 */
public class 翻转链表一 {
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> tempHead = new ListNode<>(-1);
        tempHead.next = head;
        ListNode<Integer> pre = tempHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode<Integer> cur = pre.next;
        ListNode<Integer> next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return tempHead.next;
    }

}
