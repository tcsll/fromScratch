package com.controller.inter;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ：shill
 * @date ：Created in 2020/6/16 15:32
 * @description :
 */

@FeignClient(name = "FeignServer", url = "${FeignServer.url}")
public interface FeignInterface {

    /**
     * feign调用远端接口
     * @param data 入参
     * @return 返回调用结果
     */
        @PostMapping(value = "listDevice",headers = "Content-Type=application/json")
        String testFeign(@RequestBody JSONObject data);


    }


