package com.wisely.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(); // 这里先不注册配置类

        context.getEnvironment().setActiveProfiles("dev"); //1 将活动的profile设置为prod
        context.register(ProfileConfig.class);//2后置注册Bean配置类，不然会报Bean未定义的错误
        context.refresh(); //3 刷新容器

        DemoBean demoBean = context.getBean(DemoBean.class);

        System.out.println(demoBean.getContent());

        context.close();
    }
}
