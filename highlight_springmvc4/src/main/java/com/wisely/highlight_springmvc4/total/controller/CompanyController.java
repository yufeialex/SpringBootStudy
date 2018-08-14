package com.wisely.highlight_springmvc4.total.controller;


import com.wisely.highlight_springmvc4.total.service.CompanyService;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

// 这里没有加注解
public class CompanyController {
    // 这里没有加注解
    CompanyService companyService;

    public void setFunctionService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public String SayHello(String word) {
        return companyService.getCompanyName(word);
    }


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *")
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }

}
