package cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectA {
	
		public void before() {
			System.out.println("我是A的前置通知");
		}

		public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
			System.out.println("环绕通知A开始");
			Object obj = (String) joinPoint.proceed();
			System.out.println("环绕通知A结束");
			return obj;
		}

		public void afterReturn() {
			System.out.println("我是A的后置通知");
		}
	}

