package sdk.mianshi;

/**
 * 双重检查锁，单例模式
 */
public class Singleton {
    private volatile Singleton instance;

    public Singleton getSingleton() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
