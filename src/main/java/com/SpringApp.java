package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author shill
 */

/* 启用定时任务 */
@EnableScheduling

/* 启用事务机制 */
@EnableTransactionManagement

/* 启用异步调用*/
@EnableAsync

/* 启用远程调用*/
@EnableFeignClients

/* SpringBoot启动类注解 ,可以用以下3个核心注解来代替*/
//@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan

/* 导入手动getBean: value里面传递的Class会被Spring识别成为component组件 */
@Import(com.SpringUtil.class)

public class SpringApp {
    /*
    SpringBoot启动流程,主要通过3个注解@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan

    @SpringBootConfiguration:
    对于这个注解不做解释，将这个注解点进去，发现还有@Configuration注解，
    对于@Configuration注解，用过Spring或SpringBoot的基本上都不陌生，标注了@Configuration的类相当于Spring中的配置XML，
    不过SpringBoot社区推荐使用JavaConfig，所以@Configuration就构建出了一个基础JavaConfig的Ioc容器。

    @EnableAutoConfiguration
    Spring中有很多Enable*的注解，表示开启某项东西，如@EnableSchuduling。
    所以看这个注解的名字就知道是开启自动配置。这是一个复合注解，其中最主要的还是@Import，
    借助于EnableAutoConfigurationImportSelector，将所有符合自动配置条件的Bean加载到Ioc容器里
    springBoot加载自动配置的方式有两种（目前我知道的）
    1.META-INFO/spring.factories
    2.@Import

    @ComponentScan
    看到这个注解，可以回想一下以前使用SpringMVC时，xml配置文件里的一个标签
    <context:component-scan base-package="" />
    不过这个注解一般不需要手动指定扫描的包路径，它默认会从标注了@ComponentScan的类所在包往下查找，
    将标注了如@Component，@Service等Bean加载到Ioc容器里

    整个启动流程:
    1.初始化SpringApplication类
      1.1创建一个SpringApplication对象时，会调用它自己的initialize方法
      1.2根据classpath里是否存在某个特征类(javax.servlet.Servlet,org.springframework.web.context.ConfigurableWebApplicationContext)来判断是否需要创建一个为Web应用使用的ApplicationContext。
      1.3使用SpringFactoriesLoader在应用的classpath下的所有META-INF/spring.factories中查找并加载所有可用的ApplicationContextInitializer。
      1.4使用SpringFactoriesLoader在应用的classpath下的所有META-INF/spring.factories中查找并加载所有可用的ApplicationListener。
      1.5设置main方法的定义类
    2.执行核心run方法
      2.1首先遍历执行所有通过SpringFactoriesLoader，在当前classpath下的META-INF/spring.factories中查找所有可用的SpringApplicationRunListeners并实例化。调用它们的started()方法，通知这些监听器SpringBoot应用启动。
      2.2创建并配置当前SpringBoot应用将要使用的Environment，包括当前有效的PropertySource以及Profile。
      2.3遍历调用所有的SpringApplicationRunListeners的environmentPrepared()的方法，通知这些监听器SpringBoot应用的Environment已经完成初始化。
      2.4打印SpringBoot应用的banner，SpringApplication的showBanner属性为true时，如果classpath下存在banner.txt文件，则打印其内容，否则打印默认banner。
      2.5根据启动时设置的applicationContextClass和在initialize方法设置的webEnvironment，创建对应的applicationContext。
      2.6创建异常解析器，用在启动中发生异常的时候进行异常处理(包括记录日志、释放资源等)。
      2.7设置SpringBoot的Environment，注册Spring Bean名称的序列化器BeanNameGenerator，并设置资源加载器ResourceLoader，通过SpringFactoriesLoader加载ApplicationContextInitializer初始化器，调用initialize方法，对创建的ApplicationContext进一步初始化。
      2.调用所有的SpringApplicationRunListeners的contextPrepared方法，通知这些Listener当前ApplicationContext已经创建完毕。
      2.9最核心的一步，将之前通过@EnableAutoConfiguration获取的所有配置以及其他形式的IoC容器配置加载到已经准备完毕的ApplicationContext。
      2.10调用所有的SpringApplicationRunListener的contextLoaded方法，加载准备完毕的ApplicationContext。
      2.11调用refreshContext，注册一个关闭Spring容器的钩子ShutdownHook，当程序在停止的时候释放资源（包括：销毁Bean，关闭SpringBean的创建工厂等）
      2.12获取当前所有ApplicationRunner和CommandLineRunner接口的实现类，执行其run方法
      2.13遍历所有的SpringApplicationRunListener的finished()方法，完成SpringBoot的启动。
     */

    public static void main(String[] args) {
        /* SpringApplication.run(Application.class, args); */
        SpringApplication app = new SpringApplication(SpringApp.class);
        /* 设置不展示banner: app.setBannerMode(Banner.Mode.OFF);*/
        app.run(args);

    }

}
