package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.conf.RabbitMqQueueConfig;
import com.conf.RabbitMqSender;
import com.response.ResponseBo;
//import com.service.query.LoopbackService;
import com.service.query.LoopbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author ：shill
 * @date ：Created in 2020/4/23 15:05
 * @description :
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "mq")
public class RabbitMqController {

    @Resource
    private RabbitMqSender rabbitMqSender;
    @Resource
    private RabbitMqQueueConfig rabbitMqQueueConfig;
    @Resource
    private LoopbackService loopbackService;


    @PostMapping("v1/confirm")
    public String confirm() {
        log.info(rabbitMqQueueConfig.getRabbitMqQueue() + "在线状态:" + rabbitMqSender.confirmQueue());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "这是消息消息");
        log.info("发送消息:" + jsonObject.toString());
        rabbitMqSender.sendMsg(jsonObject);
        return ResponseBo.ok();
    }


    @PostMapping("v1/loop")
    public String loop() {
        for(int i=0;i<5;i++) {
            loopbackService.confirm();
        }
        return ResponseBo.ok();
    }


}