package 链表;

/**
 * @author Yemeng
 * @create 2020-12-14-16:09
 */
public class 链表中倒数第K个节点 {
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
