package 剑指Offer2;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author shkstart
 * @create 2021-04-23 9:58
 */
public class 栈的压入弹出 {
    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] out = {4, 5, 3, 2, 1};
        System.out.println(IsPopOrder(push,out));
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    public static boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        Stack<Integer> stack = new Stack<>();
        for (int input = 0, output = 0; input < n; input++) {
            stack.push(pushSequence[input]);
            while (!stack.isEmpty() && stack.peek() == popSequence[output] && output < n) {
                stack.pop();
                output++;
            }
        }
        return stack.isEmpty();
    }
}
