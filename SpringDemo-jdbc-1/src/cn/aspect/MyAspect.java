package cn.aspect;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


import cn.bean.User;
import cn.util.SaveMap;

@Component
@Aspect
public class MyAspect {
	private HashMap<Integer, User> uMap = new HashMap<Integer, User>();
	
	@Around(value="execution(* cn.service..*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		/*SaveMap.showUserMap();
		Object obj = null;
		HashMap<Integer, User> uMap = (HashMap<Integer,User>) SaveMap.getUserMap();
		String methodName = joinPoint.getSignature().getName();
		if(methodName.equals("findOne")){
			//获取目标方法参数，返回值是Object数组
			int userid = 0 ;
			Object[] args = joinPoint.getArgs();
			for(int i =0;i<args.length;i++){
				userid = (Integer)args[i];
			}
			
			User user = uMap.get(userid);
			
			if(user !=null){
				System.out.println("成功读取缓存");
				return (Object)user;
			}else {
				obj=joinPoint.proceed();
				uMap.put(userid, (User)obj);
				System.out.println("已经缓存");
				return obj;
			}
			
			
		}

		obj=joinPoint.proceed();
		return obj;
	}*/
		
		Object obj = null;
			//获取目标方法参数，返回值是Object数组
			int userid =(Integer) joinPoint.getArgs()[0];
			User user = null;
			user = uMap.get(userid);
			System.out.println("user:"+user);
			if(user !=null){
				System.out.println("成功读取缓存");
				return (Object)user;
			}else {
				obj=joinPoint.proceed();
				uMap.put(userid, (User)obj);
				System.out.println("通过数据库查询");
				return obj;
			}
	}
}
