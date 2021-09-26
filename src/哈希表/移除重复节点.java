package 哈希表;


import 排序.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 移除重复节点 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (!set.contains(p.val)) {
                set.add(p.val);
                tail.next = p;
                tail = p;
                tail.next = null;
            }
            p = tmp;
        }
        return newHead.next;
    }
}
