package 排序;

import leetcode.ListNode;

public class 合并两个排序链表 {
    public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode<Integer> p1 = l1;
        ListNode<Integer> p2 = l2;
        ListNode<Integer> head = new ListNode<>();//虚拟头节点
        ListNode<Integer> tail = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
// 如果p1还没处理完，就把剩下的直接接到tail后⾯
        if (p1 != null) tail.next = p1;
// 同理
        if (p2 != null) tail.next = p2;
        return head.next;
    }
//    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(-1);
//        ListNode temp = res;
//        while(l1 != null||l2 != null){
//            if(l1 == null){
//                temp.next = l2;
//                l2 = l2.next;
//                temp = temp.next;
//            }else if(l2 == null){
//                temp.next = l1;
//                l1 = l1.next;
//                temp = temp.next;
//            }else if(l1.val <= l2.val){
//                temp.next = l1;
//                l1 = l1.next;
//                temp = temp.next;
//            }else{
//                temp.next = l2;
//                l2 = l2.next;
//                temp = temp.next;
//            }
//        }
//        return res.next;
//    }
}
