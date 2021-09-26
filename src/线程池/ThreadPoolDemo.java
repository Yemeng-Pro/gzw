package 线程池;

/**
 * @author shkstart
 * @create 2021-04-19 21:53
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * int corePoolSize, // 核心线程池大小
 * int maximumPoolSize, // 最大核心线程池大小
 * long keepAliveTime, // 超时了没有人调用就会释放
 * TimeUnit unit, // 超时单位
 * BlockingQueue<Runnable> workQueue, // 阻塞队列
 * ThreadFactory threadFactory, // 线程工厂：创建线程的，一般不用动
 * RejectedExecutionHandler handle // 拒绝策略
 *
 */
public class ThreadPoolDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 10; i++) {

            Runnable worker = new MyRunnable("" + "猪皮");

            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

}
