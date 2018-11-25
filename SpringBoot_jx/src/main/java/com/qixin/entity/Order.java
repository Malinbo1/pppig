package com.qixin.entity;

public class Order {
	
	private String oid;
	private double omoney;
	private double all_money;
	private Integer gid;
	private String username;
	private String ostatus;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public double getOmoney() {
		return omoney;
	}
	public void setOmoney(double omoney) {
		this.omoney = omoney;
	}
	public double getAll_money() {
		return all_money;
	}
	public void setAll_money(double all_money) {
		this.all_money = all_money;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", omoney=" + omoney + ", all_money=" + all_money + ", gid=" + gid + ", ostatus="
				+ ostatus + "]";
	}
	

}
