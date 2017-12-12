package com.wisely.ch6_5;

import com.wisely.spring_boot_starter_demoDB.DemoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch65Application {

    // demoDBService，下面的方法中用了它。但实际上这个服务是需要配置的
    // 因为它可能是个数据库服务等。所以实际上我在yml里面配置了它。而配置项其实来自于按照
    // springboot方式写好的jar和其他配置文件。然后使用者按照约定内容来使用。
    @Autowired
    DemoDBService demoDBService;

    @RequestMapping("/")
    public String index() {
        return demoDBService.connect();
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch65Application.class, args);
    }
}
