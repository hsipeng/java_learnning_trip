package cn.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PersonAspect {
	
	@Before(value="execution(* cn.service..*(..)) && args(name) && target(t)")
	public void before(String name,Object t) {
		System.out.println("前置通知");
		System.err.println("name is "+name);
	}
	
	@AfterReturning(value="execution(* cn.service..*(..))",returning="name")
	public void afterReturn(String name){
		System.out.println("返回结果:"+name);
	}
	@AfterThrowing(value="execution(* cn.servlet..*(..))",throwing="throwable")
	public void  afterThrow(JoinPoint joinPoint,Throwable throwable) {
		Class target = joinPoint.getTarget().getClass();
		String method = joinPoint.getSignature().getName();
		System.out.println("目标对象为："+target);
		System.out.println("目标方法："+method);
		System.err.println("异常类:"+throwable.getClass());
		System.err.println("异常:"+throwable.getMessage());
	}
}
