package models;

import java.util.Date;

public class InviteCode {
	private int id;
	private String code;
	private int status;
	private int userId;
	private Date regTime;
	
	
	public InviteCode() {
		super();
	}
	public InviteCode(int id, String code, int status, int userId, Date regTime) {
		super();
		this.id = id;
		this.code = code;
		this.status = status;
		this.userId = userId;
		this.regTime = regTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		return "InviteCode [id=" + id + ", code=" + code + ", status=" + status + ", userId=" + userId + ", regTime="
				+ regTime + "]";
	}
	
	
}
