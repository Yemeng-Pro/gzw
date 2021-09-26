package 栈队列堆;

import java.util.Stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
public class 最小栈 {

}


class MinStack {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> minval = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        if (data.isEmpty()) {
            data.push(val);
            minval.push(val);
        } else {
            int minValue = minval.peek();
            if (val < minValue) {
                minValue = val;
            }
            minval.push(minValue);
            data.push(val);
        }
    }

    public void pop() {
        data.pop();
        minval.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minval.peek();
    }
}