package com.component.redis.conf;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ObjectUtils;

import javax.crypto.KeyGenerator;
import java.time.Duration;

/**
 * Redis多实例配置
 *
 * @author shill
 * @date ：Created in 2019-03-07 9:48
 * @description :
 * 使用场景:
 * 1. 热点数据的缓存
 * 2. 限时业务的运用
 * 3. 计数器相关问题
 * 4. 排行榜相关问题
 * 5. 分布式锁
 * 6. 延时操作
 * 7. 分页、模糊搜索
 * 8. 点赞、好友等相互关系的存储
 * 9. 队列
 * 10. 过滤器
 */

@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    /*曾经有面试官问redis部署，你需要几台
     * 其实我理解的是他问redis的集群模式，其实讲的也就是redis的高可用方案(High Availability)
     * 1.主从同步/复制
     * 2.哨兵模式
     * 3.Cluster集群
     * */


    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    //@Value("${spring.redis.timeout}")
    private int timeout = 3000;
    @Value("${spring.redis.password}")
    private String password;
    //@Value("${spring.redis.pool.max-active}")
    private int maxActive = 5;
    //@Value("${spring.redis.pool.max-wait}")
    private int maxWait = 5;
    // @Value("${spring.redis.pool.max-idle}")
    private int maxIdle = 5;
    //@Value("${spring.redis.pool.min-idle}")
    private int minIdle = 1;


    /**
     * Jedis在实现上是直接连接的redis server，如果在多线程环境下是非线程安全的，这个时候只有使用连接池，为每个Jedis实例增加物理连接
     * Lettuce的连接是基于Netty的，连接实例（StatefulRedisConnection）可以在多个线程间并发访问，
     * 应为StatefulRedisConnection是线程安全的，所以一个连接实例（StatefulRedisConnection）就可以满足多线程环境下的并发访问，
     * 当然这个也是可伸缩的设计，一个连接实例不够的情况也可以按需增加连接实例。
     *
     * @param database  数据库索引
     * @param timeout   超时时间
     * @param maxActive 最大活跃线程
     * @param maxWait   最大等待线程
     * @param maxIdle   最大空闲线程
     * @param minIdle   最小空闲线程
     * @param hostName  主机名
     * @param port      端口
     * @param password  密码
     * @return 返回设置好的连接池factory
     */
    private LettuceConnectionFactory createConnectionFactory(int database, long timeout, int maxActive, int maxWait,
                                                             int maxIdle, int minIdle, String hostName, int port,
                                                             String password) {
        /* ========= 基本配置 ========= */
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        configuration.setDatabase(database);
        if (!ObjectUtils.isEmpty(password)) {
            RedisPassword redisPassword = RedisPassword.of(password);
            configuration.setPassword(redisPassword);
        }

        /* ========= 连接池通用配置 ========= */
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxTotal(maxActive);
        genericObjectPoolConfig.setMinIdle(minIdle);
        genericObjectPoolConfig.setMaxIdle(maxIdle);
        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
        /* ========= lettuce pool ========= */
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(genericObjectPoolConfig);
        builder.commandTimeout(Duration.ofSeconds(timeout));
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration, builder.build());
        connectionFactory.afterPropertiesSet();
        return connectionFactory;
    }


    @Bean
    public RedisTemplate<String, Object> createRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }


    /** @description :配置的RedisTemplate */
    @Bean(name = "redisTemplateSelf")
    public RedisTemplate redisTemplate() {
        LettuceConnectionFactory connectionFactory = createConnectionFactory(database, timeout, maxActive, maxWait,
                maxIdle, minIdle, host, port, password);
        return createRedisTemplate(connectionFactory);
    }


    /** @description : 配置StringRedisTemplate */
    @Bean(name = "stringRedisTemplateSelf")
    public StringRedisTemplate createStringRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        LettuceConnectionFactory connectionFactory = createConnectionFactory(database, timeout, maxActive, maxWait,
                maxIdle, minIdle, host, port, password);
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }


}
