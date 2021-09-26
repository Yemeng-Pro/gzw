package 栈队列堆;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char sth = chars[i];
            if (sth == '(' || sth == '[' || sth == '{') {
                stack.push(chars[i]);
            } else {
                if (stack.empty()) return false;
                char left = stack.pop();
                if (left == '(' && sth != ')') {
                    return false;
                } else if (left == '[' && sth != ']') {
                    return false;
                } else if (left == '{' && sth != '}') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
