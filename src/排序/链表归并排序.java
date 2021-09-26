package 排序;
public class 链表归并排序 {
    public ListNode mergeSortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode midNode = findMidNode(head);
        ListNode nextNode = midNode.next;
        midNode.next = null;
        ListNode leftHead = mergeSortList(head);
        ListNode rightHead = mergeSortList(nextNode);
        return mergeList(leftHead, rightHead);
    }


    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode mergeList(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                tail.next = pa;
                tail = tail.next;
                pa = pa.next;
            } else {
                tail.next = pb;
                tail = tail.next;
                pb = pb.next;
            }
        }
        if (pa != null) tail.next = pa;
        if (pb != null) tail.next = pb;
        return newHead.next;
    }
    //非递归实现
    public ListNode sortList(ListNode head) {
        int n = len(head);
        int step = 1;
        while (step < n) {
            ListNode newHead = new ListNode(); // 结果链表
            ListNode tail = newHead;
            ListNode p = head;
            while (p != null) {
                // [p, q]
                ListNode q = p;
                int count = 1;
                while (q != null && count < step) {
                    q = q.next;
                    count++;
                }
                //这⼀轮合并结束了
                if (q == null || q.next == null) {
                    tail.next = p;
                    break;
                }
                //[q+1, r]
                ListNode r = q.next;
                count = 1;
                while (r != null && count < step) {
                    r = r.next;
                    count++;
                }
                // 保存下⼀个step的起点
                ListNode tmp = null;
                if (r != null) {
                    tmp = r.next;
                }
                // merge[p, q][q+1, r]
                ListNode[] headAndTail = merge(p, q, r);
                tail.next = headAndTail[0];
                tail = headAndTail[1];
                p = tmp;
            }
            head = newHead.next;
            step *= 2;
        }
        return head;
    }
    private int len(ListNode head) {
        if (head == null) return 0;
        int n = 1;
        ListNode p = head;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }
    private ListNode[] merge(ListNode p, ListNode q, ListNode r) {
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode pa = p;
        ListNode pb = q.next;
        q.next = null;
        if (r != null) {
            r.next = null;
        }
        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                tail.next = pa;
                tail = tail.next;
                pa = pa.next;
            } else {
                tail.next = pb;
                tail = tail.next;
                pb = pb.next;
            }
        }
        if (pa != null) {
            tail.next = pa;
            tail = q;
        }
        if (pb != null) {
            tail.next = pb;
            tail = r;
        }
        return new ListNode[]{newHead.next, tail};
    }
}
