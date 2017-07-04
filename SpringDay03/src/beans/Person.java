package beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private int id;
	private String name;
	private List<String> list;
	private Map<String,String> map;
	private Properties pro;
	private User user;
	
	public Properties getPro() {
		return pro;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", list=" + list + ", map=" + map + ", pro=" + pro + ", user="
				+ user + "]";
	}
	
	
	
	
	
}
