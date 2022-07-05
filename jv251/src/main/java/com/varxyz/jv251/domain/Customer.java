package com.varxyz.jv251.domain;

import java.util.*;

public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passwd;
	private List<Account> account;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	
	
	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
	}
	
	public long getCid() {
		return cid;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public List<Account> getAccount() {
		return account;
	}
	
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return name + ", " + ssn + ", " + cid + ", " + phone ;
	}


}
