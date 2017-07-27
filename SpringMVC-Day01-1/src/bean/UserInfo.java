package bean;

import java.util.Date;

public class UserInfo {
	private String addr;
	private int Age;
	private Date birthday;
	
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [addr=" + addr + ", Age=" + Age + ", birthday=" + birthday + "]";
	}
	
	
	
	
}
