package 栈队列堆.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 超级丑树 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 优先级队列（⼩顶堆）
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // 先将primes放进去
        pq.add(1L);
        // 避免重复
        long lastData = -1;
        int k = 0;
        while (!pq.isEmpty() && k < n) {
            long data = pq.poll();
            if (data == lastData) {
                continue;
            }
            k++;
            lastData = data;
            // 扩展
            for (int i = 0; i < primes.length; ++i) {
                pq.add(data*primes[i]);
            }
        }
        return (int)lastData;
    }
}
