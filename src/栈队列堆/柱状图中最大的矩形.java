package 栈队列堆;

import org.junit.Test;

import java.util.Stack;

public class 柱状图中最大的矩形 {
    @Test
    public void test() {
        int[] nums = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }
    //单调栈，找到每个柱子的左右边界
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.empty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? heights.length : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}




