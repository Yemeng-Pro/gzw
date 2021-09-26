package 链表;



/**
 * @author shkstart
 * @create 2021-05-21 20:59
 */
public class 翻转链表二 {
    //k个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = head;
        ListNode next;
        ListNode pre = res;
        int length = 0;//计算链表总长度
        while (head != null) {
            length++;
            head = head.next;
        }
        head = res.next;
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k - 1; j++) {
                next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = pre.next;
        }
        return res.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        ListNode p = head;
        while (p != null) {
            int count = 0;
            ListNode q = p;
            while (q != null) {
                count++;
                if (count == k) {
                    break;
                }
                q = q.next;
            }
            if (q == null) {
                tail.next = p;
                return dummyHead.next;
            } else {
                ListNode tmp = q.next;
                ListNode[] nodes = reverse(p, q);
                tail.next = nodes[0];
                tail = nodes[1];
                p = tmp;
            }
        }
        return dummyHead.next;
    }
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode newHead = null;
        ListNode p = head;
        while (p != tail) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        tail.next = newHead;
//        newHead = tail;
        return new ListNode[]{tail, head};
    }
}
