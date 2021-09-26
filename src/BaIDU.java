/**
@author shkstart
@create 2021-04-28 15:40
*/
public class BaIDU {
    public BaIDU() {

    }
    int number = 0;
    public synchronized void increment() throws InterruptedException {
        if (number!=0){ //0
        // 等待
            Thread.sleep(1);
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        // 通知其他线程，我+1完毕了
        this.notifyAll();
    }
}
