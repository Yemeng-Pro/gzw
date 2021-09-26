package 链表;

/**
 * @author Yemeng
 * @create 2020-12-14-20:09
 */


/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import leetcode.ListNode;

/**
 * 迭代法
 */
public class 合并两个排序的列表 {
    public ListNode mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2){
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        cur.next = (l1 != null ? l1 : l2);
        return dum.next;

    }

    /**
     * 递归方法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }


}
