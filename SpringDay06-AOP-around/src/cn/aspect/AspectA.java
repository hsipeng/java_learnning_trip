package cn.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class AspectA {
	
		public void before() {
			System.out.println("����A��ǰ��֪ͨ");
		}

		public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
			System.out.println("����֪ͨA��ʼ");
			Object obj = (String) joinPoint.proceed();
			System.out.println("����֪ͨA����");
			return obj;
		}

		public void afterReturn() {
			System.out.println("����A�ĺ���֪ͨ");
		}
	}

