import java.util.List;

/**
 * @author ：shill
 * @date ：Created in 2020/6/29 22:11
 * @description :
 * 互斥锁：上一篇文章我们提到 Allocator 需要是单例的，所以我们可以用 this 作为互斥锁。
 * 线程要求的条件：转出账户和转入账户都没有被分配过。
 * 何时等待：线程要求的条件不满足就等待。
 * 何时通知：当有线程释放账户时就通知。
 */
public class test_NotifySync {

    class Allocator {
        private List<Object> als;

        // 一次性申请所有资源
        synchronized void apply(Object from, Object to) {
            // 经典写法
            while (als.contains(from) || als.contains(to)) {
                try {
                    wait();
                } catch (Exception e) {
                }
            }
            als.add(from);
            als.add(to);
        }

        // 归还资源
        synchronized void free(Object from, Object to) {
            als.remove(from);
            als.remove(to);
            notifyAll();
        }
    }

}
