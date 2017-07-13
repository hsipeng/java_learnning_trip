package cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectB {
	public void before() {
		System.out.println("我是B的前置通知");
	}

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕通知B开始");
		Object obj = (String) joinPoint.proceed();
		System.out.println("环绕通知B结束");
		return obj;
	}

	public void afterReturn() {
		System.out.println("我是B的后置通知");
	}
}
