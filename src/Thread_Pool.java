import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shkstart
 * @create 2021-03-23 22:57
 */
public class Thread_Pool {

}

class BlockingQueue<T>{
    //1.任务队列
    private Deque<T> deque = new ArrayDeque<>();
    //2.锁
    private ReentrantLock lock = new ReentrantLock();

    //3.生产者条件遍历
    private Condition fullwaitSet = lock.newCondition();

    //4.消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();
}
