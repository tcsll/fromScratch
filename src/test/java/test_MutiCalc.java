/**
 * @author ：shill
 * @date ：Created in 2020/6/28 14:28
 * @description : 缓存导致的可见性问题
 */
public class test_MutiCalc {
    private long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    private static long calc() {
        try {
            final test_MutiCalc test = new test_MutiCalc();
            // 创建两个线程，执行add()操作
            Thread th1 = new Thread(test::add10K);
            Thread th2 = new Thread(test::add10K);
            // 启动两个线程
            th1.start();
            th2.start();
            // 等待两个线程执行结束
            th1.join();
            th2.join();
            return test.count;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(calc());
    }
}

