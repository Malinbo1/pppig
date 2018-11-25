package com.qixin.entity;

public class Order {

	private String oid;
	private Integer uid;
	private double omoney;
	private Integer gid;
	private String gname;
	private double allmoney;
	private double gmoney;
	private String ostatus;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public double getOmoney() {
		return omoney;
	}
	public void setOmoney(double omoney) {
		this.omoney = omoney;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public double getAllmoney() {
		return allmoney;
	}
	public void setAllmoney(double allmoney) {
		this.allmoney = allmoney;
	}
	public double getGmoney() {
		return gmoney;
	}
	public void setGmoney(double gmoney) {
		this.gmoney = gmoney;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", omoney=" + omoney + ", gid=" + gid + ", gname=" + gname
				+ ", allmoney=" + allmoney + ", gmoney=" + gmoney + ", ostatus=" + ostatus + "]";
	}
	
	

}
