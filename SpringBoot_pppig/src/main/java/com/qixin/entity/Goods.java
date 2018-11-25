package com.qixin.entity;

public class Goods {

	private Integer gid;
	private String gname;
	private int gmon;
	private double allmoney;
	private double gmoney;
	private double glilv;
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
	public int getGmon() {
		return gmon;
	}
	public void setGmon(int gmon) {
		this.gmon = gmon;
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
	public double getGlilv() {
		return glilv;
	}
	public void setGlilv(double glilv) {
		this.glilv = glilv;
	}
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gmon=" + gmon + ", allmoney=" + allmoney + ", gmoney="
				+ gmoney + ", glilv=" + glilv + "]";
	}
	

}
