package com.wisely.highlight_springmvc4.total.annotation;

import java.lang.annotation.*;

/**
 * Created by XinYufei on 2018/1/4.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecoredTime {
    // 0表示毫秒，1表示秒
    int timeUnit() default 0;
}
