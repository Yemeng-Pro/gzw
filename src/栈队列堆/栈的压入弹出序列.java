package 栈队列堆;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        for (int pushIndex = 0, popIndex = 0; pushIndex < n; pushIndex++) {
            stack.push(pushed[pushIndex]);
            while (!stack.isEmpty() && popIndex < n && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; ++i) {
            int number = popped[i];
            if (!stack.empty() && stack.peek() == number) {
                stack.pop();
            } else {
                while (j < pushed.length && pushed[j] != number) {
                    stack.push(pushed[j]);
                    j++;
                }
                if (j == pushed.length) return false;
                j++;
            }
        }
        return true;
    }

}
