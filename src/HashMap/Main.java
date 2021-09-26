package HashMap;

import java.util.PriorityQueue;

/**
 * @author shkstart
 * @create 2021-04-27 20:13
 */
public class Main {
    public static void main(String[] args) {
    }
    public ListNode mergeKLists(ListNode[] lists) {
        //
        if(lists.length == 0) return null;
        ListNode res = new ListNode(-1);
        PriorityQueue<ListNode> que = new PriorityQueue<>();
        for(ListNode list:lists){
            if(list == null){
                continue;
            }
            que.add(list);
        }
        while(!que.isEmpty()){
            ListNode next = que.poll();
            res.next = next;
            res = res.next;
            if(next.next!=null){
                que.add(next.next);
            }
        }
        return res.next;

    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }