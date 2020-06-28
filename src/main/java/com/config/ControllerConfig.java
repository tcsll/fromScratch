// package com.config;
//
// import com.alibaba.fastjson.JSON;
// import com.alibaba.fastjson.serializer.SerializeConfig;
// import com.alibaba.fastjson.serializer.SerializerFeature;
// import com.alibaba.fastjson.serializer.ToStringSerializer;
// import com.alibaba.fastjson.support.config.FastJsonConfig;
// import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.converter.HttpMessageConverter;
// import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
// import java.math.BigInteger;
// import java.util.List;
// import java.util.TimeZone;
//
// /**
//  * 自定义WebMvc Controller配置
//  *
//  * @author huangsn
//  * @date 2019-05-07 19:24
//  */
//
// @Configuration
// public class ControllerConfig implements WebMvcConfigurer {
//
//     @Bean
//     public ControllerInterceptor controllerInterceptor() {
//         return new ControllerInterceptor();
//     }
//
//     @Override
//     public void addInterceptors(InterceptorRegistry registry) {
//         registry.addInterceptor(controllerInterceptor());
//     }
//
//     @Override
//     public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//         // 创建fastJSON转换器，以替换掉默认的Jackson
//         FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
//         // 创建fastJson配置对象
//         FastJsonConfig fjc = new FastJsonConfig();
//
//         SerializeConfig serializeConfig = SerializeConfig.globalInstance;
//
//         // 将Long型转成字符串，以解决Web端解析精度丢失问题
//         serializeConfig.put(Long.class, ToStringSerializer.instance);
//         serializeConfig.put(Long.TYPE, ToStringSerializer.instance);
//         serializeConfig.put(BigInteger.class, ToStringSerializer.instance);
//         fjc.setSerializeConfig(serializeConfig);
//
//         fjc.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
//         fjc.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty);
//         // 设置默认的日期格式化配置
//         JSON.defaultTimeZone = TimeZone.getTimeZone("GMT+8");
//         fjc.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
//
//         fastJsonConverter.setFastJsonConfig(fjc);
//
//         // 优先级高于默认的jacksonConverter，并且低于StringHttpMessageConverter
//         converters.add(3, fastJsonConverter);
//     }
// }
