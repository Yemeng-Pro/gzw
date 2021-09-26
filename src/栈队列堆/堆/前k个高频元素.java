package 栈队列堆.堆;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前k个高频元素 {
    private class QElement {
        int val;
        int count;
        public QElement(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<QElement> queue = new PriorityQueue<>(new Comparator<QElement>() {
            public int compare(QElement e1, QElement e2) {
                return e1.count - e2.count;
            }
        });
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() < k) {
                queue.offer(new QElement(num, count));
            } else {
                if (queue.peek().count < count) {
                    queue.poll();
                    queue.offer(new QElement(num, count));
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = queue.poll().val;
        }
        return result;
    }
}
