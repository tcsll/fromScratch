package com.controller;

import com.SpringUtil;
import com.alibaba.fastjson.JSONObject;
import com.component.snowflakeIdWorker.SnowflakeIdWorker;
import com.consts.Param;
import com.model.TcSll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


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
        log.info(String.valueOf(snowflakeIdWorker.nextId()));
        return "SUCCESS";
    }


    /**
     * 测试自定义starter
     *
     * @return 测试自定义starter是否加在成功
     */
    @PostMapping("autoStarter")
    public String testStarter() {
        TcSll tcSll=new TcSll();
        return tcSll.battle();
    }



    /**
     * 测试AOP鉴权
     *
     * @return 测试AOP鉴权是否成功
     */
    @PostMapping("security")
    public String testSecurity(@RequestBody JSONObject param) {
        String finalValue="sll is god";
        String name =param.getString("name");
        if(finalValue.equals(name)){
            return "最终还是成功了";
        }
        else {
            return "失败了兄弟";
        }
    }





}
