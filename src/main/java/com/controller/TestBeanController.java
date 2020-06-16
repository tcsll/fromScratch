package com.controller;

import com.SpringUtil;
import com.component.snowflakeIdWorker.SnowflakeIdWorker;
import com.consts.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * @author ：shill
 * @date ：Created in 2020/6/10 15:34
 * @description : 测试模块
 */


//@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "bean")
public class TestBeanController {

    /**
     * springBoot 接收请求的几种方式
     * 1.HttpServletRequest
     * 2.封装好的实体类
     * 3.@RequestBody注解+String data接收
     * 4.@Param获取单个值
     */
    @PostMapping("request")
    public String testGetBean(HttpServletRequest request) {
        return request.getParameter(Param.NAME);
    }



    /**
     * 测试自动获取getBean
     *
     * @return 是否getBean成功
     */
    @PostMapping("getBean")
    public String testGetBean() {
        SnowflakeIdWorker snowflakeIdWorker = SpringUtil.getBean(SnowflakeIdWorker.class);
       // log.info(String.valueOf(snowflakeIdWorker.nextId()));
        return "SUCCESS";
    }










}
