package beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {
	private int id;
	private String name;
	private User user;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Person(int id, String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", user=" + user + "]";
	}

	
	
	
	
}
