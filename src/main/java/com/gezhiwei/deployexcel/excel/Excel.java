package com.ddhz.hospitalcommunity.excel;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Excel {

    String name();

    int sort() default 0;
}
