import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author ：shill
 * @date ：Created in 2020/6/28 17:22
 * @description :
 * 看完之后你可能会觉得有点奇怪，
 * 这个和我们上面提到的模型有点对不上号啊，
 * 加锁 lock() 和解锁 unlock() 在哪里呢？
 * 其实这两个操作都是有的，
 * 只是这两个操作是被 Java 默默加上的，Java 编译器会在 synchronized 修饰的方法或代码块前后
 * 自动加上加锁 lock() 和解锁 unlock()，
 * 这样做的好处就是加锁 lock() 和解锁 unlock() 一定是成对出现的，
 * 毕竟忘记解锁 unlock() 可是个致命的 Bug（意味着其他线程只能死等下去了）。
 */


/*那 synchronized 里的加锁 lock() 和解锁 unlock() 锁定的对象在哪里呢？
上面的代码我们看到只有修饰代码块的时候，锁定了一个 obj 对象，
那修饰方法的时候锁定的是什么呢？这个也是 Java 的一条隐式规则：

当修饰非静态方法的时候，锁定的是当前实例对象 this。

*/

public class test_MethodSync {

    //--------------------------------------------------------------------------------

    /** @description : 修饰非静态方法 */
    synchronized void foo() {
        // 临界区
    }
    /*当修饰非静态方法的时候，锁定的是当前实例对象 this。*/
    //相当于: synchronized(this) void foo(){}


    //--------------------------------------------------------------------------------

    /** @description : 修饰静态方法 */
    synchronized static void bar() {
        // 临界区 }
    }

    /*当修饰静态方法的时候，锁定的是当前类的 Class 对象，在上面的例子中就是 Class X。 */
    //相当于:synchronized(X.class) static void bar() {}


    //--------------------------------------------------------------------------------

    /** @description : 修饰代码块 */
    private Object obj = new Object();

    void baz() {
        synchronized (obj) {
            // 临界区
        }
    }


    //--------------------------------------------------------------------------------
    //测试加锁的add与get

    private long value = 0L;

    private long get() {
        return value;
    }

    private synchronized void addOne() {
        value += 1;
    }


    //--------------------------------------------------------------------------------
    //这样锁会有并发性问题吗


    // class SafeCalc {
    //     static long value = 0L;
    //     synchronized long get() {
    //         return value;
    //     }
    //     synchronized static void addOne() {
    //         value += 1;
    //     }
    // }

    //--------------------------------------------------------------------------------
    //这样锁呢?
    //加锁本质就是在锁对象的对象头中写入当前线程id，但是new object每次在内存中都是新对象，所以加锁无效。

    // class SafeCalc {
    //     long value = 0L;
    //     long get() {
    //         synchronized (new Object()) {
    //             return value;
    //         }
    //     }
    //     void addOne() {
    //         synchronized (new Object()) {
    //             value += 1;
    //         }
    //     }
    // }


    public static void main(String[] args) {

        test_MethodSync test_methodSync = new test_MethodSync();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1000);

        ExecutorService executor = Executors.newFixedThreadPool(1000);

        for (int i = 0; i < 1; i++) {
            executor.execute(() -> test_methodSync.play(cyclicBarrier, test_methodSync));
        }


        // test_MethodSync test_methodSync=new test_MethodSync();
        // for (int i = 0; i < 1000; i++) {
        //     test_methodSync.addOne();
        //     System.out.println(test_methodSync.get());
        // }
        //
        // System.out.println(test_methodSync.get());
    }


    private void play(CyclicBarrier cyclicBarrier, test_MethodSync test_methodSync) {
        try {
            System.out.println(Thread.currentThread().getName() + " 已准备");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " 开始执行");
            test_methodSync.addOne();
            System.out.println(test_methodSync.get());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

}