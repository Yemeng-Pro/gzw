package leetcode;

import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-03-25 13:13
 */
public class 两个栈实现队列 {

    Stack<Integer> in;
    Stack<Integer> out;
    public 两个栈实现队列() {
       in = new Stack<>();
       out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int pop() throws Exception {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new Exception("queue is empty");

        return out.pop();
    }
}
