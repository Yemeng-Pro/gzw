package 栈队列堆.堆;

import 排序.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并k个有序链表 {
    private class QElement {
        ListNode curNode;
        public QElement(ListNode curNode) {
            this.curNode = curNode;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int k = lists.length;
        PriorityQueue<QElement> minQ = new PriorityQueue<>(new Comparator<QElement>() {
            @Override
            public int compare(QElement q1, QElement q2) {
                return q1.curNode.val - q2.curNode.val;
            }
        });
        for (int i = 0; i < k; ++i) {
            if (lists[i] != null) {
                minQ.offer(new QElement(lists[i]));
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!minQ.isEmpty()) {
            QElement element = minQ.poll();
            ListNode curNode = element.curNode;
            tail.next = element.curNode;
            tail = tail.next;
            if (curNode.next != null) {
                minQ.offer(new QElement(curNode.next));
            }
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        //
        if(lists.length == 0) return null;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        PriorityQueue<ListNode> que = new PriorityQueue<>((o1,o2)->(o1.val-o2.val));
        for(ListNode list:lists){
            if(list == null){
                continue;
            }
            que.add(list);
        }
        while(!que.isEmpty()){
            ListNode next = que.poll();
            cur.next = next;
            cur = cur.next;
            if(next.next!=null){
                que.add(next.next);
            }
        }
        return res.next;

    }
}
