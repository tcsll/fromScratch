package com.component.redis.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ：shill
 * @date ：Created in 2020/6/12 11:51
 * @description :
 */
public interface RedisUtil {
    /** @description : java类型的操作 */
    boolean set(String key, Object value);

    boolean set(String key, Object value, long time);

    /**
     * 如果键不存在则新增,存在则不改变已经有的值
     * @param key key
     * @param value value
     * @return 是否插入成功
     */
    boolean setNx(String key, Object value);

    boolean setEx(String key, Object value);

    Object get(String key);

    long incr(String key, long delta);

    long decr(String key, long delta);

    /** @description : map类型的操作 */
    boolean hmset(String key, Map<String, Object> map);

    boolean hmset(String key, Map<String, Object> map, long time);

    boolean hset(String key, String item, Object value);

    boolean hset(String key, String item, Object value, long time);

    void hdel(String key, Object... item);

    boolean hHasKey(String key, String item);

    double hincr(String key, String item, double by);

    double hdecr(String key, String item, double by);

    Object hget(String key, String item);

    Map<Object, Object> hmget(String key);

    /** @description : set类型操作 */
    Set<Object> sGet(String key);

    boolean sHasKey(String key, Object value);

    long sSet(Object key, Object... values);

    long sSetAndTime(String key, long time, Object... values);

    long sGetSetSize(String key);

    long setRemove(String key, Object... values);

    /** @description : list类型操作 */
    List<Object> lGet(String key, long start, long end);

    long lGetListSize(String key);

    Object lGetIndex(String key, long index);

    boolean lSet(String key, Object value);

    boolean lSet(String key, Object value, long time);

    boolean lSet(String key, List<Object> value);

    boolean lSet(String key, List<Object> value, long time);

    boolean lUpdateIndex(String key, long index, Object value);

    long lRemove(String key, long count, Object value);


}
