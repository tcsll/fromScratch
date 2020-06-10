package com.service.query;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author lenovo
 */
@FeignClient(name = "LoopbackService", url = "${loopbackService.url}")
public interface LoopbackService {


    /**
     * @return mq生产消费示例
     */
    @PostMapping(value = "mq/v1/confirm",headers = "Content-Type=application/json")
    String confirm();
}
