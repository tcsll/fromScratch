package com.component.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ObjectUtils;

import java.time.Duration;

/**
 * Redis多实例配置
 *
 * @author shill
 * @date ：Created in 2019-03-07 9:48
 * @description :
 * 使用场景:
 *   1. 热点数据的缓存
 *   2. 限时业务的运用
 *   3. 计数器相关问题
 *   4. 排行榜相关问题
 *   5. 分布式锁
 *   6. 延时操作
 *   7. 分页、模糊搜索
 *   8. 点赞、好友等相互关系的存储
 *   9. 队列
 *  10. 过滤器
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


    // /** @description : 默认配置的RedisTemplate */
    // @Bean
    // public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    //     return createRedisTemplate(redisConnectionFactory);
    // }

    /** @description : 自定义redisTemplate配置 */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
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


    //
    //
    // /**
    //  * 运营平台（OSS）StringRedisTemplate
    //  *
    //  * @param database
    //  * @param timeout
    //  * @param maxActive
    //  * @param maxWait
    //  * @param maxIdle
    //  * @param minIdle
    //  * @param hostName
    //  * @param port
    //  * @param password
    //  * @return
    //  */
    // @Bean(name = "stringRedisTemplateOSS")
    // public StringRedisTemplate stringRedisTemplateOSS(
    //         @Value("${spring.redis.timeout}") long timeout,
    //         @Value("${spring.redis.pool.max-active}") int maxActive,
    //         @Value("${spring.redis.pool.max-wait}") int maxWait,
    //         @Value("${spring.redis.pool.max-idle}") int maxIdle,
    //         @Value("${spring.redis.pool.min-idle}") int minIdle,
    //         @Value("${spring.redis_oss.host}") String hostName,
    //         @Value("${spring.redis_oss.port}") int port,
    //         @Value("${spring.redis_oss.password}") String password,
    //         @Value("${spring.redis_oss.database}") int database) {
    //
    //     LettuceConnectionFactory connectionFactory = createConnectionFactory(database, timeout, maxActive, maxWait,
    //             maxIdle, minIdle, hostName, port, password);
    //
    //     /* ========= 创建 template ========= */
    //     return createStringRedisTemplate(connectionFactory);
    // }
    //
    // /**
    //  * 运营平台（OSS）的RedisTemplate
    //  *
    //  * @param database
    //  * @param timeout
    //  * @param maxActive
    //  * @param maxWait
    //  * @param maxIdle
    //  * @param minIdle
    //  * @param hostName
    //  * @param port
    //  * @param password
    //  * @return
    //  */
    // @Bean(name = "redisTemplateOSS")
    // public RedisTemplate redisTemplateOSS(
    //         @Value("${spring.redis.timeout}") long timeout,
    //         @Value("${spring.redis.pool.max-active}") int maxActive,
    //         @Value("${spring.redis.pool.max-wait}") int maxWait,
    //         @Value("${spring.redis.pool.max-idle}") int maxIdle,
    //         @Value("${spring.redis.pool.min-idle}") int minIdle,
    //         @Value("${spring.redis_oss.host}") String hostName,
    //         @Value("${spring.redis_oss.port}") int port,
    //         @Value("${spring.redis_oss.password}") String password,
    //         @Value("${spring.redis_oss.database}") int database) {
    //
    //     LettuceConnectionFactory connectionFactory = createConnectionFactory(database, timeout, maxActive, maxWait,
    //             maxIdle, minIdle, hostName, port, password);
    //
    //     /* ========= 创建 template ========= */
    //     return createRedisTemplate(connectionFactory);
    // }
    //
    // /**
    //  * 调度服务（DSS）StringRedisTemplate
    //  *
    //  * @param database
    //  * @param timeout
    //  * @param maxActive
    //  * @param maxWait
    //  * @param maxIdle
    //  * @param minIdle
    //  * @param hostName
    //  * @param port
    //  * @param password
    //  * @return
    //  */
    // @Bean(name = "stringRedisTemplateDSS")
    // public StringRedisTemplate stringRedisTemplateDSS(
    //         @Value("${spring.redis.timeout}") long timeout,
    //         @Value("${spring.redis.pool.max-active}") int maxActive,
    //         @Value("${spring.redis.pool.max-wait}") int maxWait,
    //         @Value("${spring.redis.pool.max-idle}") int maxIdle,
    //         @Value("${spring.redis.pool.min-idle}") int minIdle,
    //         @Value("${spring.redis_dss.host}") String hostName,
    //         @Value("${spring.redis_dss.port}") int port,
    //         @Value("${spring.redis_dss.password}") String password,
    //         @Value("${spring.redis_dss.database}") int database) {
    //
    //     LettuceConnectionFactory connectionFactory = createConnectionFactory(database, timeout, maxActive, maxWait,
    //             maxIdle, minIdle, hostName, port, password);
    //
    //     /* ========= 创建 template ========= */
    //     return createStringRedisTemplate(connectionFactory);
    // }
    //
    // @Bean(name = "redisTemplateDSS")
    // public RedisTemplate redisTemplateDSS(
    //         @Value("${spring.redis.timeout}") long timeout,
    //         @Value("${spring.redis.pool.max-active}") int maxActive,
    //         @Value("${spring.redis.pool.max-wait}") int maxWait,
    //         @Value("${spring.redis.pool.max-idle}") int maxIdle,
    //         @Value("${spring.redis.pool.min-idle}") int minIdle,
    //         @Value("${spring.redis_dss.host}") String hostName,
    //         @Value("${spring.redis_dss.port}") int port,
    //         @Value("${spring.redis_dss.password}") String password,
    //         @Value("${spring.redis_dss.database}") int database) {
    //
    //     LettuceConnectionFactory connectionFactory = createConnectionFactory(database, timeout, maxActive, maxWait,
    //             maxIdle, minIdle, hostName, port, password);
    //
    //     /* ========= 创建 template ========= */
    //     return createRedisTemplate(connectionFactory);
    // }
    //
    // /**
    //  * 创建连接工厂
    //  *
    //  * @param database
    //  * @param timeout
    //  * @param maxActive
    //  * @param maxWait
    //  * @param maxIdle
    //  * @param minIdle
    //  * @param hostName
    //  * @param port
    //  * @param password
    //  * @return
    //  */
    // public LettuceConnectionFactory createConnectionFactory(int database, long timeout, int maxActive, int maxWait,
    //                                                         int maxIdle, int minIdle, String hostName, int port,
    //                                                         String password) {
    //     /* ========= 基本配置 ========= */
    //     RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
    //     configuration.setHostName(hostName);
    //     configuration.setPort(port);
    //     configuration.setDatabase(database);
    //     if (!ObjectUtils.isEmpty(password)) {
    //         RedisPassword redisPassword = RedisPassword.of(password);
    //         configuration.setPassword(redisPassword);
    //     }
    //
    //     /* ========= 连接池通用配置 ========= */
    //     GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
    //     genericObjectPoolConfig.setMaxTotal(maxActive);
    //     genericObjectPoolConfig.setMinIdle(minIdle);
    //     genericObjectPoolConfig.setMaxIdle(maxIdle);
    //     genericObjectPoolConfig.setMaxWaitMillis(maxWait);
    //     /* ========= lettuce pool ========= */
    //     LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
    //     builder.poolConfig(genericObjectPoolConfig);
    //     builder.commandTimeout(Duration.ofSeconds(timeout));
    //     LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(configuration, builder.build());
    //     connectionFactory.afterPropertiesSet();
    //     return connectionFactory;
    // }
    //
    // /**
    //  * 实现 redisTemplate
    //  *
    //  * @param redisConnectionFactory
    //  * @return
    //  */
    // public RedisTemplate createRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    //     RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    //
    //     redisTemplate.setConnectionFactory(redisConnectionFactory);
    //
    //     Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //     objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    //     jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
    //
    //     redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    //     redisTemplate.setKeySerializer(new StringRedisSerializer());
    //     redisTemplate.afterPropertiesSet();
    //     return redisTemplate;
    // }
    //
    // /**
    //  * 实现 StringRedisTemplate
    //  *
    //  * @param redisConnectionFactory
    //  * @return
    //  */
    // public StringRedisTemplate createStringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    //     StringRedisTemplate redisTemplate = new StringRedisTemplate();
    //     redisTemplate.setConnectionFactory(redisConnectionFactory);
    //
    //     return redisTemplate;
    // }
}
