package 栈队列堆;

import java.util.Stack;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.empty() && temperatures[i] > temperatures[stack.peek()]){
                int j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }


}
