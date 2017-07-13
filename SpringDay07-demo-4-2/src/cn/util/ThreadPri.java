package cn.util;

import java.util.List;

public class ThreadPri {
//在当前线程内共享数据，实现线程安全
	private static ThreadLocal<List<String>> threadLocal = new ThreadLocal<List<String>>();

	public static void setList(List<String> lsit){
		threadLocal.set(lsit);
	}
	public static List<String> getList(){
		return threadLocal.get();
	}
	
}
