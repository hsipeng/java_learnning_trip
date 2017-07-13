package cn.aspect;
//定义切面 该切面专门用来处理事务

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.util.LangUtil.ProcessController.Thrown;
import org.springframework.stereotype.Component;

import cn.tx.TranscationManager;

@Component
public class TxAspect {
	@Resource
	private TranscationManager tx;
	
	//前置通知
	public void before(JoinPoint joinPoint){
		System.out.println("我是一个前置通知");
		//获取目标对象的类型
		Class targetClass = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("目标对象类型是："+targetClass);
		System.out.println("目标方法是:"+methodName);
	}
	//后置通知 如果想返回结果值
	public void afterReturn(JoinPoint joinPoint,String number){
		System.out.println("我是一个后置通知");
		System.out.println("保存目标方法执行后的结果为："+number);
	}
	/*异常通知
	 * 1.打印异常类型
	 * 2.打印异常信息
	 */
	public void afterThrow(Throwable throwable){
		System.out.println("我是一个异常通知");
		System.out.println("异常信息类型为："+throwable.getClass());
		System.out.println("异常信息为："+throwable.getMessage());
	}
	//最终通知
	public void after(){
		System.out.println("我是一个最终通知");
	}
	
	
	
	
	
	
	
	
	
	
//	//定义通知
//	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
//		tx.begin();//事务开启
//		joinPoint.proceed();//让目标方法执行
//		tx.commit();//事务提交
//		
//		
//	}
	
	
	
	
	
}
