package com.controller;

import com.component.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：shill
 * @date ：Created in 2020/6/10 15:34
 * @description : 测试模块
 */


@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "test")
public class TestController {
    @Resource
    private SnowflakeIdWorker snowflakeIdWorker;

    @PostMapping("test")
    public String test() {
        log.info(String.valueOf(snowflakeIdWorker.nextId()));
        return "SUCCESS";
    }


}
