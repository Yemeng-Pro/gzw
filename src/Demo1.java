/**
 * @author shkstart
 * @create 2021-04-26 11:02
 */
public class Demo1 {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> stringInheritable = new InheritableThreadLocal<>();

        // 主线程赋对上面两个变量进行赋值
        stringThreadLocal.set("this is threadLocal");
        stringInheritable.set("this is inheritableThreadLocal");

        // 创建线程
        Thread thread1 = new Thread(()->{
            // 获得ThreadLocal中存放的值
            System.out.println(stringThreadLocal.get());

            // 获得InheritableThreadLocal存放的值
            System.out.println(stringInheritable.get());
        });

        thread1.start();
    }
}