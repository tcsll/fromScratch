package com.controller;

import com.model.TcSll;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：shill
 * @date ：Created in 2020/6/16 9:59
 * @description :
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "starer")
public class TestStarerController {
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

}
