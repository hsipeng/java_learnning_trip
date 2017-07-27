package bean;

import java.util.Arrays;

public class User {
	private String username;
	private String name;
	private String password;
	private String tel;
	private String[] hobby;
	
	private UserInfo userInfo;
	
	
	
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", password=" + password + ", tel=" + tel + ", hobby="
				+ Arrays.toString(hobby) + ", userInfo=" + userInfo + "]";
	}
	
	
	
}
