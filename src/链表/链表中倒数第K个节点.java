package 链表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yemeng
 * @create 2020-12-14-16:09
 */
public class 链表中倒数第K个节点 {
    public ListNode func(ListNode head, int k) {
        ListNode newhead = new ListNode(-1);
        ListNode temp = getKthFromEnd(head, k + 1);
        newhead.next = temp;
        ListNode p = newhead;
        while (p != null) {
            p = p.next;
        }
        p.next = head;
        return newhead.next;

    }
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode former = head;
        ListNode latter = head;
        for(int i = 0; i < k; i++){
            latter = latter.next;
        }
        while(latter != null){
            former = former.next;
            latter = latter.next;
        }
        return former;
    }
}
