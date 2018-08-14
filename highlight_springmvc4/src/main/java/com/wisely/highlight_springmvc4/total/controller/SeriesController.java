package com.wisely.highlight_springmvc4.total.controller;


import com.wisely.highlight_springmvc4.total.service.SeriesService;
import org.springframework.scheduling.annotation.Async;

// 这里没有加注解
public class SeriesController {
    // 这里没有加注解
    SeriesService seriesService;

    public void setFunctionService(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    public String SayHello() {
        return seriesService.getContent();
    }

    @Async // 如果加在类上，所有方法就都是异步的
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务: " + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任务+1: " + (i + 1));
    }

}
