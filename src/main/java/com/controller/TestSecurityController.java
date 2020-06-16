package com.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：shill
 * @date ：Created in 2020/6/16 9:56
 * @description :
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "security")
public class TestSecurityController {

    /**
     * 测试AOP鉴权
     *
     * @return 测试AOP鉴权是否成功
     */
    @PostMapping("aop")
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
