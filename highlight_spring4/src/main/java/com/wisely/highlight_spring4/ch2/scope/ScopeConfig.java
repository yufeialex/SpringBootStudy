package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 下面的注解是一定要的，开启注解配置
@ComponentScan("com.wisely.highlight_spring4.ch2.scope")
public class ScopeConfig {

}
