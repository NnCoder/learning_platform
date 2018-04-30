package com.edu.manager.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 清除课程缓存注解
 * @Description TODO
 * @ClassName ClearCourseCache
 * @author Tao
 * @date 2018年4月11日
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CleanCourseCache {

}
