package com.wisely.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeHystrixService {

    @Autowired
    RestTemplate restTemplate; //1 注入后可以使用ribbon

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome() {
        // 这里不写真正的地址，就写服务名就行
        return restTemplate.getForObject("http://some/getsome", String.class);
    }

    public String fallbackSome() {
        return "some service模块故障";
    }
}
