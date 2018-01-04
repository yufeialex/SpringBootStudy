package com.wisely.highlight_springmvc4.total.service;

// 这里没有加注解
public class SeriesService {

    private String content;

    public SeriesService(String content) {
        super();
        this.content = content;
    }

    public void init() {
        System.out.println("@Bean-init-method");
    }

    public String getSeriesName(String word) {
        return "series is " + word + " !";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public void destroy() {
        System.out.println("@Bean-destory-method");
    }

}
