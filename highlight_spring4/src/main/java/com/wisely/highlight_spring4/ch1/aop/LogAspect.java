package com.wisely.highlight_spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Aspect //1 声明这是一个切面
@Component //2 本切面被Spring管理
public class LogAspect {

    @Pointcut("@annotation(com.wisely.highlight_spring4.ch1.aop.WithDoc)") //3 声明切点；切的标志就是注解
    public void annotationPointCut() {
    }

    @After("annotationPointCut()") //4，声明一个advice（建言）并使用@Pointcut定义的切点；使用方法是用那个注解注释的函数
    // 每一个被拦截的地方就叫连接点，JoinPoint，所以这里的参数就是被切的方法
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        WithDoc withDoc = method.getAnnotation(WithDoc.class);
        System.out.println("注解式拦截 " + withDoc.name()); //5 通过反射可以获得注解上的属性，然后做日志记录相关的操作，下面类似
    }

    @After("@annotation(withDoc)") //4，直接写规则,与某一个参数绑定
    // 每一个被拦截的地方就叫连接点，JoinPoint，所以这里的参数就是被切的方法
    public void after1(WithDoc withDoc) {
        System.out.println("注解式拦截2 " + withDoc.name()); //5 通过反射可以获得注解上的属性，然后做日志记录相关的操作，下面类似
    }

    @Before("execution(* com.wisely.highlight_spring4.ch1.aop.DemoMethodService.*(..))") //6 直接写拦截规则
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截," + method.getName());

    }


}
