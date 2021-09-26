package 栈队列堆;

import java.util.Stack;

public class 接雨水 {
    //动态规划
    //result += Math.min(left,right)-height[i]
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];
        int leftMax = left[0];
        int rightMax = right[n - 1];
        int res = 0;
        for (int i = 1; i < n; i++) {
            leftMax = Math.max(height[i], leftMax);
            left[i] = leftMax;
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax = Math.max(height[i], rightMax);
            right[i] = rightMax;
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    //单调栈
    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (height[i] == height[top]) {
                    stack.pop();
                    stack.push(i);
                    break;
                } else if (height[i] < height[top]) {
                    stack.push(i);
                    break;
                } else {
                    int mid = height[stack.pop()];
                    if (stack.empty()) {
                        stack.push(i);
                        break;
                    }
                    int left = stack.peek();
                    int h = Math.min(height[i],height[left]) - mid;
                    int m = i - left - 1;
                    res += h * m;
                }
            }
        }
        return res;
    }
}
