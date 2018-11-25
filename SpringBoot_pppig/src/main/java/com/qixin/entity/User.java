package com.qixin.entity;

public class User {

	private Integer uid;
	private String username;
	private String password;
	private String uphone;
	private double u_yue;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public double getU_yue() {
		return u_yue;
	}
	public void setU_yue(double u_yue) {
		this.u_yue = u_yue;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", uphone=" + uphone
				+ ", u_yue=" + u_yue + "]";
	}
	
	
}
