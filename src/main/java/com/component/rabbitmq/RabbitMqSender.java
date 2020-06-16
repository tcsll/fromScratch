// package com.component.rabbitmq;
//
//
// import com.alibaba.fastjson.JSONObject;
// import com.rabbitmq.client.Channel;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.amqp.core.Message;
// import org.springframework.amqp.core.MessageProperties;
// import org.springframework.amqp.rabbit.connection.ConnectionFactory;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.context.annotation.Scope;
// import org.springframework.stereotype.Service;
//
// import javax.annotation.Resource;
// import java.io.IOException;
// import java.util.concurrent.TimeoutException;
//
//
// /**
//  * @author shill
//  */
// @Service
// @Slf4j
// @Scope("prototype")
// public class RabbitMqSender {
//
//     @Resource
//     private RabbitTemplate rabbitTemplate;
//     @Resource
//     private RabbitMqQueueConfig rabbitMqQueueConfig;
//
//     /** @description : 检查队列是否在线 */
//     public boolean confirmQueue() {
//         ConnectionFactory connectionFactory = rabbitTemplate.getConnectionFactory();
//         try (Channel channel = connectionFactory.createConnection().createChannel(false)) {
//             channel.queueBind(rabbitMqQueueConfig.getRabbitMqRoutingKey(),"cloud.topic", rabbitMqQueueConfig.getRabbitMqQueue());
//             return true;
//         } catch (IOException e) {
//             return false;
//         } catch (TimeoutException e) {
//             e.printStackTrace();
//             return false;
//         }
//     }
//
//
//     public void sendMsg(JSONObject sendData) {
//         MessageProperties messageProperties = new MessageProperties();
//         messageProperties.setContentType("application/json");
//         String sendMsg = sendData.toJSONString();
//         Message message = new Message(sendMsg.getBytes(), messageProperties);
//         rabbitTemplate.send("cloud.topic", rabbitMqQueueConfig.getRabbitMqRoutingKey(), message);
//
//     }
//
//
//
// }
