package 栈队列堆;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 两个队列实现栈 {
}


class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }
    /** Get the top element. */
    public int top() {
        int n = queue.size();
        for (int i = 0; i < n - 1; i++) {
            queue.add(queue.poll());
        }
        int ret = queue.poll();
        queue.offer(ret);
        return ret;
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

class MyStack2 {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack2() {
        queue = new LinkedList<>();
    }
    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}