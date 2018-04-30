package com.edu.manager.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edu.manager.service.CourseService;
/**
 * 清除课程缓存Aop
 * @Description TODO
 * @ClassName CleanCourseCacheAspect
 * @author Tao
 * @date 2018年4月11日
 */
@Aspect
@Component
public class CleanCourseCacheAspect {
	
	@Autowired
	private CourseService courseService;
	
	@Pointcut("@annotation(com.edu.manager.annotation.CleanCourseCache)")
	public void pointCut() {}
	
	@Around("pointCut()")
	public Object afterUpdate(ProceedingJoinPoint point) throws Throwable {
		courseService.cleanCache((Integer)point.getArgs()[0]);
		Object object = point.proceed();
		return object;
	}
}
