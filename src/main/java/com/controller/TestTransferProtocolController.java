package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.component.http.util.RequestUtil;
import com.controller.inter.FeignInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：shill
 * @date ：Created in 2020/6/16 10:02
 * @description : 传输协议 http 与 rpc
 */

@CrossOrigin
@RestController
@RequestMapping(value = "doPost")
public class TestTransferProtocolController {
    @Resource
    private FeignInterface feignInterface;

    @Resource
    private RestTemplate restTemplate;

    private final static String MEMBER_CODE = "710805c3e3ae430f91107147f4beb619";
    private final static String API_KEY = "9EMUXGZK";
    private final static String POST_URL = "http://api.poscom.cn/apisc/listDevice";

    private Map<String, String> params = new HashMap<>(8);


    private void buildParams() {
        String reqTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        this.params.put("reqTime", reqTime);
        this.params.put("securityCode", DigestUtils.md5Hex(MEMBER_CODE + reqTime + API_KEY));
        this.params.put("memberCode", MEMBER_CODE);
    }


    //调用HTTP请求的方式

    @PostMapping(value = "self")
    public String doPostBySelf() {
        buildParams();
        System.out.println(params.toString());
        return RequestUtil.sendPost(POST_URL, params);
    }


    @PostMapping(value = "rest")
    public String doPostByRestTemplate() {
        System.out.println("开始任务");

        buildParams();
        System.out.println(params.toString());

        //需要head
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        //转换成http entity
        HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);
        System.out.println(request.toString());

        //返回response entity
        ResponseEntity<String> response = restTemplate.postForEntity(POST_URL, request, String.class);
        System.out.println(response.getBody());

        System.out.println("结束任务");

        return response.getBody();

    }


    @PostMapping(value = "feign")
    public String doPostByFeign() {
        buildParams();
        System.out.println(params.toString());

        JSONObject paramJson = JSONObject.parseObject(JSON.toJSONString(params));
        System.out.println(paramJson.toJSONString());

        String result = feignInterface.testFeign(paramJson);
        System.out.println(result);
        return result;
    }


    //调用RPC请求的方式
    //了解一下 dubbo 就好



}
