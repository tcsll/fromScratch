package com.concurrent;

import java.util.concurrent.*;

/**
 * @author ：shill
 * @date ：Created in 2020/5/29 12:15
 * @description :
 */
public class ThreadPool {

    private int threadNum = 10;
    private int maximumPoolSize = 20;
    private int keepAliveTime = 5;

    public ThreadPool() {
        ExecutorService selectDate =
                new ThreadPoolExecutor(
                        threadNum,
                        maximumPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        new ThreadPoolExecutor.DiscardPolicy());


        //Executors.newSingleThreadExecutor()
        //selectDate.execute();
    }


}
