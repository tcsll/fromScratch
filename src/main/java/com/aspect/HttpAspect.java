// package com.aspect;
//
// import com.alibaba.fastjson.JSONObject;
// import lombok.extern.slf4j.Slf4j;
// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.*;
// import org.springframework.stereotype.Component;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;
//
// import javax.servlet.http.HttpServletRequest;
// import java.util.Objects;
//
//
// /**
//  * @author ：shill
//  * @date ：Created in 2019/11/5 16:51
//  * @description : http aop
//  */
// @Slf4j
// @Aspect
// @Component
// public class HttpAspect {
//
//
//     @Pointcut(value = "execution(public * com.controller.*.*(..))")
//
//
//     public void log() {
//         log.info("在这里执行切面操作");
//     }
//
//     @Before("log()")
//     public void doBefore(JoinPoint joinPoint) {
//         ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//         HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
//
//
//         log.info("在切面操作之前获取ip信息");
//         //URL
//         log.info("URL={}", request.getRequestURL());
//
//         //Method
//         log.info("Method={}", request.getMethod());
//
//         //IP
//         log.info("IP={}", request.getRemoteAddr());
//
//         //Class.Method
//         log.info("CLass.Method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");
//
//         //Args
//         log.info("Args={}", joinPoint.getArgs());
//
//         //...其余操作
//
//     }
//
//     @Around("log()")
//     public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//         long startTime = System.currentTimeMillis();
//         Object result = joinPoint.proceed();
//         long endTime = System.currentTimeMillis();
//
//         log.info("spendTime={}", (int) (endTime - startTime));
//
//         log.info("result={}", JSONObject.toJSON(result));
//
//         return result;
//     }
//
//     @After("log()")
//     public void doAfter() {
//         log.info("结束切面操作");
//     }
//
// }