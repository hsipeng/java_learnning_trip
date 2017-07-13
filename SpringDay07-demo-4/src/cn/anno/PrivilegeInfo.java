package cn.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@Target(ElementType.METHOD)//指定运行在方法上
@Retention(RetentionPolicy.RUNTIME)//在何时运行
public @interface PrivilegeInfo {
	public String name();
}
