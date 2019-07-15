package com.hbc.annotation;

/**
 * @Author: Beer
 * @Date: 2019/7/15 19:10
 * @Description:
 */
public @interface WarmUp {
    int iterations() default 0;
}
