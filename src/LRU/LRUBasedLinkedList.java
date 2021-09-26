package LRU;

import leetcode.ListNode;

import java.util.Scanner;


/**
 * @author shkstart
 * @create 2021-05-20 15:44
 */
public class LRUBasedLinkedList<T> {
    public static void main(String[] args) {
        LRUBasedLinkedList<Integer> list = new LRUBasedLinkedList<>(5);
        Scanner in = new Scanner(System.in);
        while (true) {
            list.add(in.nextInt());
            list.printAll();
        }
    }
    /**
     * 默认链表大小
     */
    private static final Integer DEFAULT_CAPACITY = 10;
    /**
     * 链表头节点
     */
    private final ListNode<T> headNode;
    /**
     * 链表长度
     */
    private Integer length;
    /**
     * 链表容量
     */
    private final Integer capacity;

    public LRUBasedLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
        this.headNode = new ListNode<>();
    }

    public LRUBasedLinkedList(Integer capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.headNode = new ListNode<>();
    }

    public void add(T data) {
        ListNode<T> pre = findPreNode(data);
        //若链表中存在，则删除原数据，并插入到链表的头部
        if (pre != null) {
            deleteElemOptim(pre);
            insertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                deleteAtEnd();
            }
            insertElemAtBegin(data);
        }
    }


    /**
     * 单向链表只能遍历来找到前节点
     * @param data
     * @return
     */
    private ListNode<T> findPreNode(T data) {
        ListNode<T> node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getVal())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 从链表中删除节点
     */
    private void deleteElemOptim(ListNode<T> preNode) {
        ListNode<T> temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    private void deleteAtEnd() {
        ListNode<T> temp = headNode;
        if (temp.getNext() == null) {
            return;
        }
        //遍历到倒数第二个节点
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        ListNode<T> last = temp.getNext();
        temp.setNext(null);
        last = null;
        length--;
    }

    /**
     * 把节点加入到链表头部
     */
    private void insertElemAtBegin(T data) {
        ListNode<T> next = headNode.getNext();
        headNode.setNext(new ListNode<T>(data, next));
        length++;
    }

    /**
     * 打印所有节点
     */
    private void printAll() {
        ListNode<T> node = headNode.getNext();
        while (node != null) {
            if (node.getNext() == null) {
                System.out.println(node.getVal());
            } else {
                System.out.println(node.getVal() + ",");
            }
            node = node.getNext();
        }
        System.out.println();
    }






}

