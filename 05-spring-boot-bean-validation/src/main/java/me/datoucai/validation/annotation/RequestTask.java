package me.datoucai.validation.annotation;

import java.lang.annotation.*;

/**
 * @author cc
 * @date 2019/2/13
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestTask {
    boolean required() default true;
}
