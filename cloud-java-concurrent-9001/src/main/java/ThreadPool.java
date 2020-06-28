import java.util.concurrent.*;

/**
 * @author ：shill
 * @date ：Created in 2020/5/29 12:15
 * @description : 线程池
 */
public class ThreadPool {

    private int threadNum = 10;
    private int maximumPoolSize = 20;
    private int keepAliveTime = 5;

    public ThreadPool() {
        ExecutorService selectDate =
                new ThreadPoolExecutor(threadNum, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>(),
                        new ThreadPoolExecutor.DiscardPolicy());


        //Executors.newSingleThreadExecutor()
        //selectDate.execute();
    }


}
