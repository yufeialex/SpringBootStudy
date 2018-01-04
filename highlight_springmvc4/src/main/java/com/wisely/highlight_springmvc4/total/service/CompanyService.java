package com.wisely.highlight_springmvc4.total.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 这里没有加注解
public class CompanyService {
    @PostConstruct
    public void init() {
        System.out.println("jsr250-init-method");
    }

    public String getCompanyName(String word) {
        return "company is " + word + " !";
    }

    @PreDestroy
    public void destroy() {
        System.out.println("jsr250-destory-method");
    }
}
