package 链表;

/**
 * @author Yemeng
 * @create 2020-12-14-17:09
 */
public class 反转链表 {
    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
        ListNode newList = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next; //暂存后续节点
            head.next = newList.next;
            newList.next = head;
            head = next;
        }
        return newList.next;
    }

    public ListNode reverseList(ListNode head) {
//        if (head == null) return null;
        ListNode newHead = null;
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = newHead;
            newHead = p;
            p = tmp;
        }
        return newHead;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        return recur(head, null);    // 调用递归并返回
    }
    private ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) return pre; // 终止条件
        ListNode res = recur(cur.next, cur);  // 递归后继节点
        cur.next = pre;              // 修改节点引用指向
        return res;                  // 返回反转链表的头节点
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next2 = head.next;
        head.next = null;
        ListNode newHead = ReverseList(next2);
        next2.next = head;
        return newHead;
    }


    public leetcode.ListNode<Integer> reverseBetween(leetcode.ListNode<Integer> head, int left, int right) {
        leetcode.ListNode<Integer> tempHead = new leetcode.ListNode<>(-1);
        tempHead.next = head;
        leetcode.ListNode<Integer> pre = tempHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        leetcode.ListNode<Integer> cur = pre.next;
        leetcode.ListNode<Integer> next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return tempHead.next;
    }
}
