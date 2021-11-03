package 生产者消费者问题;

/**
 * @author shkstart
 * @create 2021-04-19 14:48
 */
public class pc1 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

}

class Data { // 数字 资源类
    private int number = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (number != 0) { //0
// 等待
            this.wait();
            Thread.sleep(1000);
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
// 通知其他线程，我+1完毕了
        this.notifyAll();

    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) { // 1
            // 等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
// 通知其他线程，我-1完毕了
        this.notifyAll();
    }
}