package com.component.redis.scene;

import com.component.redis.util.RedisUtil;
import com.component.redis.util.RedisUtilImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @author ：shill
 * @date ：Created in 2020/6/12 14:23
 * @description : 分布式锁
 *
 * 互斥性：相互排斥。在任何给定时刻，只有一个客户端可以持有锁。
 * 无死锁：最终，即使锁定资源的客户端崩溃或被分区，也始终可以获取锁定。
 * 容错性：容错，只要大多数Redis节点启动，客户端就能够获取和释放锁。
 * 解铃还须系铃人。加锁和解锁必须是同一个客户端，客户端自己不能把别人加的锁给解了。
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DistributedLockTest {
    private final RedisTemplate redisTemplateSelf;

    @Autowired
    public DistributedLockTest(RedisTemplate redisTemplateSelf) {
        this.redisTemplateSelf = redisTemplateSelf;
    }

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

        //redisTemplateSelf.opsForValue().set();

        // String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        //
        // if (LOCK_SUCCESS.equals(result)) {
        //     return true;
        // }
        return false;

    }





    @Test
    public void impl(){

    }

}
