package com.wisely.highlight_spring4.ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //1 组合元注解
@ComponentScan //2 组合元注解
public @interface WiselyConfiguration {

    String[] value() default {}; //3 覆盖value参数

}
