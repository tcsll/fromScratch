package com.spring.characteristic.aop;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;


/**
 * @author ：shill
 * @date ：Created in 2019/11/5 16:51
 * @description : spring aop
 * 常用场景:
 * 鉴权 & 打开数据库连接/关闭数据库连 & 打开事务/关闭事 & 记录日志等
 * 事务 @Transactional
 * 安全 @PreAuthorize
 * 缓存 @Cacheable
 */
//@Slf4j
@Aspect
@Component
public class TestAop {
    /*Spring AOP 底层原理
    有那么点多。。待我先理解下
    *
    * */

    /** @description : 权限控制到某个接口 */
    @Pointcut(value = "execution(public * com.controller.TestSecurityController.testSecurity(..))")
    //@Pointcut(value = "execution(public * com.controller.*.*(..))")

    private void accessControl() {
    }


    /** @description : 前置通知（Before）：在目标方法被调用之前调用通知功能。 */
    @Before("accessControl()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        //log.info("在切面操作之前获取ip信息");
        //URL
       // log.info("URL={}", request.getRequestURL());

        //Method
      //  log.info("Method={}", request.getMethod());

        //IP
       // log.info("IP={}", request.getRemoteAddr());

        //Class.Method
      //  log.info("CLass.Method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");

        //Args
       // log.info("Args={}", joinPoint.getArgs());

        //...其余操作

    }


    /** @description : 后置通知（After）：在目标方法完成之后调用通知，此时不会关心方法的输出是什么。 */
    @After("accessControl()")
    public void doAfter() {
        //log.info("无论正常异常都会输出");
    }


    /** @description : 返回通知（After-returning）：在目标方法成功执行之后调用通知。 */
    @AfterReturning("accessControl()")
    public void doAfterReturning() {
     //   log.info("正常返回结果");
    }


    /** @description : 异常通知（After-throwing）：在目标方法抛出异常后调用通知。 */
    @AfterThrowing("accessControl()")
    public void doAfterThrowing() {
      //  log.info("异常返回结果");
    }


    /** @description : 环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。 */
    @Around("accessControl()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        boolean isPass = false;
        String key = "name";
        String value = "sll is god";

        //获取入参[仅测试一个入参("name":"sll")]
        JSONObject param = JSONArray.parseArray((Arrays.toString(joinPoint.getArgs()))).getJSONObject(0);
        if (param.containsKey(key) && (value).contains(param.getString(key))) {
            isPass = true;
        }

        if (isPass) {
            System.out.println("第一步验证通过");
            return joinPoint.proceed();
        } else {
            return "权限验证无法通过";
        }
    }


}