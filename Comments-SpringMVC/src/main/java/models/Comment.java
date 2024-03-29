package models;

import java.sql.Timestamp;
import java.util.Date;



public class Comment {
	private int id;
	private int userId;
	private String content;
	private String publishTime;
	private String modifyTime;
	private int status;
	private String username;
	public Comment(){
		
	}
	
	public Comment(int id, int userId, String content, String publishTime, String modifyTime, int status,
			String username) {
		super();
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.publishTime = publishTime;
		this.modifyTime = modifyTime;
		this.status = status;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String timestamp) {
		this.publishTime = timestamp;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", userId=" + userId + ", content=" + content + ", publishTime=" + publishTime
				+ ", modifyTime=" + modifyTime + ", status=" + status + "]";
	}
	
	
}
