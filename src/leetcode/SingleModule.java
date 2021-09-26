package leetcode;

/**
 * @author shkstart
 * @create 2021-04-02 20:30
 */
public class SingleModule {
    private SingleModule(){
        synchronized (SingleModule.class){
            if(singleModule!=null){
                throw new RuntimeException("不要使用反射破坏单例！");
            }
        }
    }
    private volatile static SingleModule singleModule;
    public static SingleModule getInstance(){
        //判断对象是否实例过，没有实例化过才加锁
        if(null == singleModule){
            synchronized (SingleModule.class){
                if (null == singleModule){
                    singleModule = new SingleModule();//不是原子操作，因此加volatile禁止指令重排，
                }
            }
        }
        return singleModule;
    }
}


class Singleton_02{
    private static class SingletonHolder {
        private static Singleton_02 instance = new Singleton_02();
    }
    private Singleton_02() {
    }
    public static Singleton_02 getInstance() {
        return SingletonHolder.instance;
    }
}

enum EnumSingle{
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }
}
