package leetcode;

/**
 * @author shkstart
 * @create 2021-05-10 21:33
 */
public class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public ListNode() {this.next = null;}
    public ListNode(T val) { this.setVal(val); }
    public ListNode(T val, ListNode<T> next) { this.setVal(val); this.next = next; }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
