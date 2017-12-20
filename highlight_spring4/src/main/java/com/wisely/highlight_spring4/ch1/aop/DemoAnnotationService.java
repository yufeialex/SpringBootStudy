package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @WithDoc(name = "注解式拦截的add操作")
    public void add(){} 
   
}
