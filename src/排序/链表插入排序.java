package 排序;


public class 链表插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
// 存储已经排好序的节点
        ListNode newHead = new ListNode(Integer.MIN_VALUE, null);
// 遍历节点
        ListNode p = head;
        while (p != null) {
            ListNode tmp = p.next;
// 寻找p节点插⼊的位置,插⼊到哪个节点后⾯
            ListNode q = newHead; // 初始化值
            while (q.next != null && q.next.val <= p.val) { // 循环结束条件
                q = q.next;
            }
// 将p节点插⼊
            p.next = q.next;
            q.next = p;
            p = tmp;
        }
        return newHead.next;
    }
}
