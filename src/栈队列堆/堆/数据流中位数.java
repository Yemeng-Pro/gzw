package 栈队列堆.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中位数 {
    private PriorityQueue<Integer> minQueue = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    });
    private PriorityQueue<Integer> maxQueue = new PriorityQueue(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
//    public MedianFinder() {}
    public void addNum(int num) {
        if (maxQueue.isEmpty() || num <= maxQueue.peek()) {
            maxQueue.add(num);
        } else {
            minQueue.add(num);
        }
        while (maxQueue.size() < minQueue.size()) {
            Integer e = minQueue.poll();
            maxQueue.add(e);
        }
        while (minQueue.size() < maxQueue.size()-1) {
            Integer e = maxQueue.poll();
            minQueue.add(e);
        }
    }
    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) {
            return maxQueue.peek();
        } else {
            return (maxQueue.peek()+minQueue.peek())/2f;
        }
    }


    /* 大顶堆，存储左半边元素 */
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    /* 小顶堆，存储右半边元素，并且右半边元素都大于左半边 */
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    /* 当前数据流读入的元素个数 */
    private int N = 0;

    public void Insert(Integer val) {
        /* 插入要保证两个堆存于平衡状态 */
        if (N % 2 == 0) {
            /* N 为偶数的情况下插入到右半边。
             * 因为右半边元素都要大于左半边，但是新插入的元素不一定比左半边元素来的大，
             * 因此需要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为最大元素，此时插入右半边 */
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();//N从0开始，所以总数据为奇数的时候，右顶堆比左顶堆多一个
    }
}
