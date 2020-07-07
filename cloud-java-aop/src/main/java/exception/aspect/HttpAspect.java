package exception.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shill
 * @Created 2019-05-05.
 * @Version v1.0
 * @description com.demo.aspect
 * # @CopyRight 2003-2019 浩鲸云计算科技股份有限公司 版权所有| All Rights Reserved
 */
@Aspect
@Component
@Slf4j
public class HttpAspect {
    @Pointcut("execution(public * exception.controller..*(..))")
    public void log() {
        log.info("test");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        if (joinPoint.getArgs() != null) {
            log.info("[url]={},[method]={},[ip]={},[args]={}",
                    request.getRequestURI(), request.getMethod(), request.getRemoteAddr(), joinPoint.getArgs());
        } else {
            log.info("[url]={},[method]={},[ip]={}",
                    request.getRequestURI(), request.getMethod(), request.getRemoteAddr());
        }
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        log.info("[return]={}", JSON.toJSONString(object));
    }
}
