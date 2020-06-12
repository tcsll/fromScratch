package com.component.redis.scene;

import com.component.redis.util.RedisUtilImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;


/**
 * @author ：shill
 * @date ：Created in 2020/6/11 17:38
 * @description :
 * 热点数据缓存
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class HotSpotDataTest {
    @Resource
    private RedisUtilImpl redisUtilImpl;

    @Test
    public void impl(){

        //------------------存数据------------------
        //String
        redisUtilImpl.setNx("stringKey","stringValue");
        //Map
        Map<String,Object> map=new HashMap<>(1);
        map.put("testMap","testValue");
        redisUtilImpl.hmset("mapKey",map);
        //Set
        Set<Object> set=new HashSet<>(1);
        set.add("testSet");
        set.forEach(s-> redisUtilImpl.sSet("setKey",s));
        //List
        List<String> list =new ArrayList<>();
        list.add("testList");
        redisUtilImpl.lSet("listKey",list);
        //Object
        // Model model=new Model("id","name");
        // redisUtil.s

        //------------------取数据------------------
        log.info("String类型:"+   redisUtilImpl.sGet("stringKey"));
        log.info("Map类型:"+ redisUtilImpl.hmget("mapKey"));
        log.info("Set类型:"+ redisUtilImpl.sGet("setKey"));
        log.info("List类型:"+ redisUtilImpl.lGetIndex("listKey",0));


    }

}
