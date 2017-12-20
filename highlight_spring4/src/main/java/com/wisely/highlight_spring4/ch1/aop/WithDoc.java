package com.wisely.highlight_spring4.ch1.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WithDoc {
    String name();
}
