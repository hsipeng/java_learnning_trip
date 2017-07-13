package cn.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
@Component
public class MyAspect {

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕通知开始");
		Object obj = (String) joinPoint.proceed();
		System.out.println(obj);
		System.out.println("环绕通知结束");
		return obj;
	}
	public void afterReturn(String number){
		System.out.println("返回通知"+number);
	}
	

	public void afterThrow(Throwable throwable){
		System.out.println("异常通知"+throwable.getMessage());
	}
}
