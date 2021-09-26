package 递归分治;

import java.util.ArrayList;
import java.util.List;

public class 从尾到头打印链表 {
    //实现方法一
    List<Integer> result = new ArrayList<>();

    private void reverseTravel(ListNode head) {
        if (head == null) return;
        reverseTravel(head.next);
        result.add(head.val);
    }
    public int[] reversePrint(ListNode head) {
        reverseTravel(head);
        int[] resultArr = new int[result.size()];
        int i = 0;
        for (Integer k : result) {
            resultArr[i++] = k;
        }
        return resultArr;
    }

}

class Solution {
    //实现方法二
    public int[] reversePrint(ListNode head) {
        List<Integer> result = new ArrayList<>();
        reverseTravel(head, result);
        int[] resultArr = new int[result.size()];
        int i = 0;
        for (Integer k : result) {
            resultArr[i++] = k;
        }
        return resultArr;
    }
    private void reverseTravel(ListNode head, List<Integer> result) {
        if (head == null) return;
        reverseTravel(head.next, result);
        result.add(head.val);
    }


    //实现方法三
    public int[] reversePrint3(ListNode head) {
        if (head == null) return new int[0];
        int[] subresult = reversePrint(head.next);
        int[] result = new int[subresult.length+1];
        for (int i = 0; i < subresult.length; ++i) {
            result[i] = subresult[i];
        }
        result[result.length-1] = head.val;
        return result;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}