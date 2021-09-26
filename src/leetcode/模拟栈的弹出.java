package leetcode;


import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-03-26 17:16
 */
public class 模拟栈的弹出 {
    Stack<Integer> stack = new Stack();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
