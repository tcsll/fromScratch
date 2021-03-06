// package com.component.rabbitmq;
//
// import org.springframework.amqp.core.AcknowledgeMode;
// import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
// import org.springframework.amqp.rabbit.connection.ConnectionFactory;
// import org.springframework.amqp.rabbit.core.RabbitAdmin;
// import org.springframework.amqp.rabbit.core.RabbitTemplate;
// import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
// import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
// import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
// import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
// import org.springframework.amqp.support.converter.MessageConverter;
// import org.springframework.amqp.support.converter.SerializerMessageConverter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Scope;
//
// import javax.annotation.Resource;
//
//
// /**
//  * @author shill
//  * @date ：Created in 2020-06-11 15:51
//  * @description :
//  * rabbitMq 使用场景:
//  * 1.异步处理 -- 短信/邮件
//  * 2.应用解耦 -- 用户下单后,订单系统需要通知库存系统
//  * 3.流量削峰 -- 可以控制活动人数，超过此一定阀值的订单直接丢弃(我为什么秒杀一次都没有成功过呢^^)
//  *
//  */
// @Configuration
// public class RabbitMqConfig {
//     @Resource
//     private RabbitMqQueueConfig rabbitMqQueueConfig;
//
//     @Bean
//     public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
//         RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
//         //设置忽略声明异常
//         rabbitAdmin.setIgnoreDeclarationExceptions(true);
//         return rabbitAdmin;
//     }
//
//
//
//
//
//     @Bean
//     @Scope("prototype")
//     public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//         RabbitTemplate template = new RabbitTemplate(connectionFactory);
//         template.setMandatory(true);
//         template.setMessageConverter(new SerializerMessageConverter());
//         return template;
//     }
//
//
//     @Bean
//     public MessageConverter messageconverter() {
//         ContentTypeDelegatingMessageConverter messageConverter = new ContentTypeDelegatingMessageConverter();
//         messageConverter.addDelegate("text/plain", new Jackson2JsonMessageConverter());
//         return  messageConverter;
//     }
//
//     @Bean
//     public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
//         SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//         factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//         factory.setConnectionFactory(connectionFactory);
//         factory.setMessageConverter(messageConverter);
//         return factory;
//     }
//
//
//    @Bean
//    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(rabbitMqQueueConfig.getRabbitMqQueue());
//        MessageListenerAdapter adapter = new MessageListenerAdapter(new RabbitMqMessageHandler());
//        //指定Json转换器
//        adapter.setMessageConverter(messageconverter());
//        //设置处理器的消费消息的默认方法
//        adapter.setDefaultListenerMethod("onMessage");
//        container.setMessageListener(adapter);
//        return container;
//    }
//
//
// }
//
