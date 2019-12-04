package com.wts.shop.domain;

import java.util.List;

public class Store {

	private Integer sid;
	private String sname;
	private String datea;
	private List<Goods> goodes;
	
	public List<Goods> getGoodes() {
		return goodes;
	}
	public void setGoodes(List<Goods> goodes) {
		this.goodes = goodes;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDatea() {
		return datea;
	}
	public void setDatea(String datea) {
		this.datea = datea;
	}
}
