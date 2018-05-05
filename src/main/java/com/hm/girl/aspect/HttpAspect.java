package com.hm.girl.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
    public void doBefore(){
        System.out.println("拦截请求---方法执行前");
        //推荐使用logger打印
        logger.info("拦截请求---方法执行前");

        //--------------------------------------------


    }

    //@After("execution(public * com.hm.girl.controller.GirlController.*(..))")//  .*(..) 拦截所有方法
    @After("log()")
    public void doAfter(){
        System.out.println("方法执行后。。。");
        logger.info("方法执行后。。。");
    }



}












