package cn.aspect;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import cn.tx.TranscationManager;

//定义切面，专门用来处理事务
@Component
public class TxAspect {
	@Resource
	private TranscationManager tx;
	
	//定义通知
//	public void around(ProceedingJoinPoint joinPoint){
//		try {
//			tx.begin();//事务开始
//			joinPoint.proceed();//目标方法执行
//			tx.commit();//事务提交
//		} catch (Throwable e) {
//			tx.rollback();
//			e.printStackTrace();
//		}
//	}
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕通知开始");
		Object obj = (String) joinPoint.proceed();
		System.out.println(obj);
		System.out.println("环绕通知结束");
		return obj;
	}

	public void afterReturn(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();  
        System.out.println("the method name is "+methodName+" and result is " + result);  
	}
}
