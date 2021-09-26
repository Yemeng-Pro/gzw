package 栈队列堆;

import java.util.Stack;

public class 栈排序 {

}
class SortedStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    public SortedStack() {
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() < val) {
            tempStack.push(stack.pop());
        }
        stack.push(val);
        while (!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }
    }

    public int peek() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class SortedStack2 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    public SortedStack2() {
    }

    public void push(int val) {
        stack.push(val);
    }
    //先遍历stack，找到最小值，再将temp中除了最小值外的都放回去
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int minValue = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            int val = stack.pop();
            minValue = Math.min(minValue, val);
            tempStack.push(val);
        }
        boolean removed = false;
        while (!tempStack.isEmpty()) {
            int val = tempStack.pop();
            if (val != minValue || removed) {
                stack.push(val);
            } else {
                removed = true;
            }
        }
    }

    public int peek() {
        if (stack.isEmpty()) return -1;
        int minVal = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            int val = stack.pop();
            if (val < minVal) minVal = val;
            tempStack.push(val);
        }
        while (!tempStack.isEmpty()) {
            int val = tempStack.pop();
            stack.push(val);
        }
        return minVal;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}