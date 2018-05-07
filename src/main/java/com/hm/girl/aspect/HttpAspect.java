package com.hm.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.CORBA.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * AOP面向切面编程
 */
@Aspect
@Component//引入文件到spring容器
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);//日志记录  HttpAspect.class参数对应类名

    //@Before("execution(public * com.hm.girl.controller.GirlController.girlList(..))")//  .. 表示任何参数
    @Pointcut("execution(public * com.hm.girl.controller.GirlController.*(..))")//  .*(..) 拦截所有方法
    public void log(){
        System.out.println("这个为什么不打印log()");
    }

    /**
     * 所拦截的方法执行之前执行
     */
    //@Before("execution(public * com.hm.girl.controller.GirlController.*(..))")//  .*(..) 拦截所有方法
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("拦截请求---方法执行前");
        //推荐使用logger打印
        logger.info("拦截请求---方法执行前");

        //----------------- 获取http请求的内容 ---------------------------
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取url
        logger.info("url={}",request.getRequestURL());
        //获取method
        logger.info("method={}",request.getMethod());
        //获取ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法                                    获取类名                                                获取类方法
        logger.info("class_method{}",joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }

    //@After("execution(public * com.hm.girl.controller.GirlController.*(..))")//  .*(..) 拦截所有方法
    @After("log()")
    public void doAfter(){
        System.out.println("方法执行后。。。");
        logger.info("方法执行后。。。");
    }

    /**
     * 获取返回的内容 （请求得到的数据）
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        System.out.println("获取方法执行后返回的内容。。。doAfterReturning()");
        logger.info("resopnse={}",object.toString());
    }


}












