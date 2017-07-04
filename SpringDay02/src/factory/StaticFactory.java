package factory;

import java.util.Calendar;

public class StaticFactory {
	public  StaticFactory() {
		System.out.println("静态构造");
	}
	public static Calendar getCalender() {
		
		return Calendar.getInstance();
	}
}
