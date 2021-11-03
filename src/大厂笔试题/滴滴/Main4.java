package 大厂笔试题.滴滴;

import java.util.Scanner;
import java.util.Stack;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String array = in.nextLine();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (array.charAt(i) == '0' || array.charAt(i) == '2') {
                stack.push(i);
            } else if (stack.peek()!=-1 && (array.charAt(i) == '1' && array.charAt(stack.peek()) == '0')) {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    result = Math.max(result, i - stack.peek());
                }
            } else if (stack.peek()!=-1 && (array.charAt(i) == '3' && array.charAt(stack.peek()) == '2')){
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    result = Math.max(result, i - stack.peek());
                }
            }else{
                stack.push(i);
            }
        }
        System.out.println(result);

    }
}
