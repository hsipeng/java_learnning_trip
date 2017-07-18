package cn.util;



import java.util.HashMap;
import java.util.Map;

import cn.bean.User;

public class SaveMap {
	static Map<Integer, User> uMap= new HashMap<Integer,User>();
	
	public static Map<Integer, User> getUserMap(){
		return uMap;
	}
	
	public static void saveToUserMap(int i,User user){
		uMap.put(i, user);
	}
	
	public static User getUserFromMap(int i){
		for(int key:uMap.keySet()){
			if(key == i){
				return uMap.get(key);
			}
		}
		return null;
	}
	
	public static void showUserMap(){
		for (int key : uMap.keySet()) {
			System.out.println("id:"+key+"user:"+uMap.get(key));
		}
	}
}
