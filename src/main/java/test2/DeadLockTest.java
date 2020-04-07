package test2;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ThreadFactory;

/**
 * @author ：shill
 * @date ：Created in 2020/1/9 10:25
 * @description : 死锁
 */


public class DeadLockTest {
    private final static Object LOCK_A = new Object();
    private final static Object LOCK_B = new Object();

    public static void main(String[] args) {
        new DeadLockTest().forTheLock();
    }


    /**
     * 争抢锁
     */
    private void forTheLock() {
        ThreadFactory threadFactory=new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
        //ExecutorService sda=new Tread

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK_A) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "已经获取了A锁了,准备去获取B锁");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + "休眠500ms");

                        System.out.println(Thread.currentThread().getName() + "需要B锁");
                        synchronized (LOCK_B) {
                            System.out.println("获取B锁成功");

                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        },"线程1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LOCK_B) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "已经获取了B锁了,准备去获取A锁");
                        Thread.sleep(500);
                        System.out.println(Thread.currentThread().getName() + "休眠500ms");

                        System.out.println(Thread.currentThread().getName() + "需要A锁");
                        synchronized (LOCK_A) {
                            System.out.println("获取A锁成功");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            }
        },"线程2");

        thread1.start();
        thread2.start();


    }


}
