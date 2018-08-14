package com.wisely.ch8_6_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableMongoRepositories spring需要，boot不需要，已经帮我们配置了
public class Ch861Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch861Application.class, args);
    }


}
