package 链表;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    class Node {
        Node next;
        Node pre;
        int key;
        int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;
    private int capacity;
    private static Map<Integer, Node> cash = new HashMap<>();
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        Node node = cash.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            size++;
            cash.put(key, newNode);
            //插入头部
            addToHead(newNode);
            //扩容
            if (this.size > this.capacity) {
                Node temp = removeTail();
                cash.remove(temp);
                this.size--;
            }
        } else {
            node.value = value;
            //移动到链表头部
            moveToHead(node);
        }

    }

    public int get(int key) {
        Node node = cash.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }else{
            return -1;
        }

    }

    private void addToHead(Node node) {
        node.next  = head.next;
        head.next = node;
        node.pre = head;
        node.next.pre = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private Node removeTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}
