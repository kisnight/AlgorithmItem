package study.demo.synchron;

public class Singleton {
    // 这里volatile 修饰 Singleton
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        // 先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if(uniqueInstance == null) {
            // 对类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
