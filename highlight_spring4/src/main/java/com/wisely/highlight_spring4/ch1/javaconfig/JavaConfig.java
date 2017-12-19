package com.wisely.highlight_spring4.ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 这里不用@ComponentScan，不用注解配置，用java配置
public class JavaConfig {
    @Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService()); // 注入方式1，构造器注入
        return useFunctionService;

    }

//	@Bean
    // 注入方式2，如果某个Bean已经在容器中，可以作为参数放入另一个Bean的声明方法中
//	public UseFunctionService useFunctionService(FunctionService functionService){
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}
}
