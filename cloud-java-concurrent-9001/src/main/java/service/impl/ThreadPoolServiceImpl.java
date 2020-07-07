package service.impl;

import org.springframework.stereotype.Service;
import service.SelfThreadPoolService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @author ：shill
 * @date ：Created in 2020/6/28 16:35
 * @description :
 */

@Service
public class ThreadPoolServiceImpl implements SelfThreadPoolService {

    @Override
    public ExecutorService selfNewFiexedThreadPool(int threads) {
        return newFixedThreadPool(threads);
    }

    /**
     * @param Threads
     * @return
     */
    @Override
    public ExecutorService selfNewCachedThreadPool(int Threads) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public ExecutorService selfNewSingleThreadExecutor() {
        return newSingleThreadExecutor();
    }

    /**
     * @param corePoolSize
     * @return
     */
    @Override
    public ExecutorService selfNewScheduledThreadPool(int corePoolSize) {
        return null;
    }
}
