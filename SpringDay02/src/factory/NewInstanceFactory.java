package factory;

import java.util.Calendar;

public class NewInstanceFactory {
	public NewInstanceFactory(){
		System.out.println("通过构造方法创建工厂对象");
	}
	
	public Calendar getCalendar(){
		return Calendar.getInstance();
	}
}
