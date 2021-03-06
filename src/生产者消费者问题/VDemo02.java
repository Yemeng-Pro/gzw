package 生产者消费者问题;

/**
 * @author shkstart
 * @create 2021-04-19 15:36
 */
public class VDemo02 {
    // volatile 不保证原子性
    private volatile static int num = 0;
    public static void add(){
        num++;
    }
    public static void main(String[] args) {
    //理论上num结果应该为 2 万
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000 ; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){ // main gc
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }
}
