package com.wisely.highlight_springmvc4.annotation;

import java.lang.annotation.*;

/**
 * Created by XinYufei on 2018/1/4.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddMagnet {
    boolean required() default true;
}
