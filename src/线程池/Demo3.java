package 线程池;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2021-04-19 22:24
 */
public class Demo3 {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2,  TimeUnit.SECONDS, 1, 4);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(()->{
                try {
                    TimeUnit.SECONDS.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务正在执行!");
            });
        }
    }
}


/**
 * 自定义线程池
 */
class ThreadPool {
    /**
     * 自定义阻塞队列
     */
    private BlockingQueue<Runnable> blockingQueue;

    /**
     * 核心线程数
     */
    private int coreSize;

    private HashSet<Worker> workers = new HashSet<>();

    /**
     * 用于指定线程最大存活时间
     */
    private TimeUnit timeUnit;
    private long timeout;

    /** 工作线程类
     * 内部封装了Thread类，并且添加了一些属性
     */
    private class Worker extends Thread {
        Runnable task;

        public Worker(Runnable task) {
            System.out.println("初始化任务");
            this.task = task;
        }

        @Override
        public void run() {
            // 如果有任务就执行
            // 如果阻塞队列中有任务，就继续执行
            while (task != null || (task = blockingQueue.take()) != null) {
                try {
                    System.out.println("执行任务");
                    task.run();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    // 任务执行完毕，设为空
                    System.out.println("任务执行完毕");
                    task = null;
                }
            }
            // 移除任务
            synchronized (workers) {
                System.out.println("移除任务");
                workers.remove(this);
            }
        }
    }

    public ThreadPool(int coreSize, TimeUnit timeUnit, long timeout, int capacity) {
        this.coreSize = coreSize;
        this.timeUnit = timeUnit;
        blockingQueue = new BlockingQueue<>(capacity);
        this.timeout = timeout;
    }

    public void execute(Runnable task) {
        synchronized (workers) {
            // 创建任务
            // 池中还有空余线程时，可以运行任务
            // 否则阻塞
            if (workers.size() < coreSize) {
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            } else {
                System.out.println("线程池中线程已用完，请稍等");
                blockingQueue.put(task);
            }
        }
    }
}

/**
 * 阻塞队列
 * 用于存放主线程或其他线程产生的任务
 */
class BlockingQueue<T> {
    /**
     * 阻塞队列
     */
    private Deque<T> blockingQueue;

    /**
     * 阻塞队列容量
     */
    private int capacity;

    /**
     * 锁
     */
    private ReentrantLock lock;

    /**
     * 条件队列
     */
    private Condition fullQueue;
    private Condition emptyQueue;


    public BlockingQueue(int capacity) {
        blockingQueue = new ArrayDeque<>(capacity);
        lock = new ReentrantLock();
        fullQueue = lock.newCondition();
        emptyQueue = lock.newCondition();
        this.capacity = capacity;
    }

    /**
     * 获取任务的方法
     */
    public T take() {
        // 加锁
        lock.lock();
        try {
            // 如果阻塞队列为空（没有任务），就一直等待
            while (blockingQueue.isEmpty()) {
                try {
                    emptyQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 获取任务并唤醒生产者线程
            T task = blockingQueue.removeFirst();
            fullQueue.signalAll();
            return task;
        } finally {
            lock.unlock();
        }
    }

    public T takeNanos(long timeout, TimeUnit unit) {
        // 转换等待时间
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (blockingQueue.isEmpty()) {
                try {
                    // awaitNanos会返回剩下的等待时间
                    nanos = emptyQueue.awaitNanos(nanos);
                    if (nanos < 0) {
                        return null;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = blockingQueue.removeFirst();
            fullQueue.signalAll();
            return task;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 放入任务的方法
     * @param task 放入阻塞队列的任务
     */
    public void put(T task) {
        lock.lock();
        try {
            while (blockingQueue.size() == capacity) {
                try {
                    System.out.println("阻塞队列已满");
                    fullQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            blockingQueue.add(task);
            // 唤醒等待的消费者
            emptyQueue.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int getSize() {
        lock.lock();
        try {
            return blockingQueue.size();
        } finally {
            lock.unlock();
        }
    }
}