package com.conf;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * @author shill
 */
@Slf4j

public class RabbitMqMessageHandler {


    public void onMessage(byte[] message) {
        log.info("---------onMessage----byte-------------");
        try {
            String msg = new String(message, "utf-8");
            log.info("消费消息:"+msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
