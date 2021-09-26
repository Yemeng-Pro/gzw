package leetcode;

/**
 * @author shkstart
 * @create 2021-03-26 14:14
 */
public class 交换两个排序链表 {
    public ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2){
        ListNode<Integer> list1 = l1,list2 = l2;
        ListNode<Integer> Head = new ListNode<>(Integer.MIN_VALUE);
        ListNode<Integer> cur = Head;
        while (l1 != null && l2 != null) {
            if (l1.getVal() >= l2.getVal()) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return Head.next;


    }
}
