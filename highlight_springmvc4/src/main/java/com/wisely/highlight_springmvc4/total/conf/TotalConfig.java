package com.wisely.highlight_springmvc4.total.conf;

import com.wisely.highlight_springmvc4.total.annotation.WiselyConfiguration;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

// 这里是总的配置，total项目从这里启动，因为下面的扫描，所以我还能配置多个带有@Configuration注解的文件。那些就用JavaConfig方式来配置
//@Configuration //1 组合元注解
//@ComponentScan("com.wisely.highlight_springmvc4.total")
@WiselyConfiguration("com.wisely.highlight_springmvc4.total") // 这种扫描是配合注解配置用的
@EnableAspectJAutoProxy // 开启Spring对AspectJ代理的支持
@EnableAsync // 开启异步任务
@EnableScheduling // 开启对计划任务的支持
public class TotalConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {//2 重写
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
