package com.conf;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lenovo
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mq-queue-name")
public class RabbitMqQueueConfig {
   private String rabbitMqRoutingKey;
   private String rabbitMqQueue;

    @Override
    public String toString() {
        return rabbitMqRoutingKey+":"+rabbitMqQueue;
    }

}
