import java.lang.reflect.Constructor;

/**
 * @author shkstart
 * @create 2021-03-23 20:25
 */
public class LazyMan {
//    private static boolean qinjiang = false;
    private LazyMan(){
        synchronized (LazyMan.class){
            if (lazyMan != null){
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }
    }
    private volatile static LazyMan lazyMan;
    // 双重检测锁模式的 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if (lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan(); // 不是一个原子性操作
                }
            }
        }
        return lazyMan;
    }
    // 反射！
    public static void main(String[] args) throws Exception {

//        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
//        Field qinjiang = LazyMan.class.getDeclaredField("qinjiang");
//        qinjiang.setAccessible(true);
//        Constructor<LazyMan> declaredConstructor =
//                LazyMan.class.getDeclaredConstructor(null);
//        declaredConstructor.setAccessible(true);
        LazyMan instance2  = declaredConstructor.newInstance();
        LazyMan instance3  = declaredConstructor.newInstance();
        LazyMan instance4  = declaredConstructor.newInstance();
//        qinjiang.set(instance,false);
//        LazyMan instance2 = declaredConstructor.newInstance();
        System.out.println(instance2);
        System.out.println(instance3);
        System.out.println(instance4);
    }
}




