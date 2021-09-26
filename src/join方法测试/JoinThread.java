package join方法测试;

public class JoinThread extends Thread{
    public JoinThread() {
    }
    @Override
    public void run() {
        System.out.println("子线程开始");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程结束");
        synchronized (this){
            this.notifyAll();
        }
    }


}