package bean;

import java.util.List;

public class Dept {
	private Integer deptId;
	private String deptName;
	
	private List<User> uList;
	
	public List<User> getuList() {
		return uList;
	}
	public void setuList(List<User> uList) {
		this.uList = uList;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", uList=" + uList + "]";
	}
	
	
}
