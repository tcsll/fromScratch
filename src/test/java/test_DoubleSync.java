/**
 * @author ：shill
 * @date ：Created in 2020/6/28 14:58
 * @description :
 * 编译优化带来的有序性问题
 * 在 Java 领域一个经典的案例就是利用双重检查创建单例对象，
 * 例如下面的代码：在获取实例 getInstance() 的方法中，我们首先判断 instance 是否为空，
 * 如果为空，则锁定 Singleton.class 并再次检查 instance 是否为空，如果还为空则创建 Singleton 的一个实例。
 */

public class test_DoubleSync {
    private  static test_DoubleSync instance;

    private static test_DoubleSync getInstance() {
        if (instance == null) {
            synchronized (test_DoubleSync.class) {
                if (instance == null)
                    instance = new test_DoubleSync();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
