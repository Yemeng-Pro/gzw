package join方法测试;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始");
        Thread thread = new JoinThread();
        thread.start();
        while (thread.isAlive()) {
            synchronized (thread){
                thread.wait();
            }
//防止子线程调用notifyAll时线程还活着，使得main线程重新在thread对象上陷入等待队列
            Thread.sleep(5000);
        }

        System.out.println("主线程结束");
    }
}