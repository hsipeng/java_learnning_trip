package cn.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.anno.Transactional;
import cn.tx.TranscationManager;
@Component
@Aspect
public class PersonAspect {
	
	@Resource
	private TranscationManager tx;
	
	@Around(value="execution(* cn.service..*(..)) && @annotation(tran)")
	public Object around(ProceedingJoinPoint joinPoint,Transactional tran) throws Throwable {
		tx.begin();
		Object object = joinPoint.proceed();
		tx.commit();
		return object;
	}
	
	@AfterThrowing(value="execution(* cn.service..*(..))",throwing="throwable")
	public void  afterThrow(JoinPoint joinPoint,Throwable throwable) {
		tx.rollback();
		Class target = joinPoint.getTarget().getClass();
		String method = joinPoint.getSignature().getName();
		System.out.println("目标对象为："+target);
		System.out.println("目标方法："+method);
		System.err.println("异常类:"+throwable.getClass());
		System.err.println("异常:"+throwable.getMessage());
	}
}
