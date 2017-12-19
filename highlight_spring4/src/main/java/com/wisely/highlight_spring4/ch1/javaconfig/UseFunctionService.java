package com.wisely.highlight_spring4.ch1.javaconfig;

// 这里没有加注解
public class UseFunctionService {
    // 这里没有加注解
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public String SayHello(String word) {
        return functionService.sayHello(word);
    }

}
