package 栈队列堆;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    @Test
    public void test() {
        int[] sb = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(sb,3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] res = new int[n - k + 1];
        Deque<Integer> que = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && que.peekLast() < nums[i]) {
                que.pollLast();
            }
            que.addLast(nums[i]);
        }
        res[index++] = que.peekFirst();
        for (int i = k; i < n; i++) {
            if (nums[i - k] == que.peekFirst()) {
                que.pollFirst();
            }
            while (!que.isEmpty() && que.peekLast() < nums[i]) {
                que.pollLast();
            }
            que.addLast(nums[i]);
            res[index++] = que.peekFirst();
        }
        return res;
    }

}
