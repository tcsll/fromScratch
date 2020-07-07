package service;

import java.util.concurrent.ExecutorService;

/**
 * @author ：shill
 * @date ：Created in 2020/6/28 16:34
 * @description :
 */


public interface SelfThreadPoolService {


    ExecutorService selfNewFiexedThreadPool(int threads);

    /**
     * @param Threads
     * @return
     */
    ExecutorService selfNewCachedThreadPool(int Threads);

    /**
     * @return
     */
    ExecutorService selfNewSingleThreadExecutor();

    /**
     * @param corePoolSize
     * @return
     */
    ExecutorService selfNewScheduledThreadPool(int corePoolSize);

}
