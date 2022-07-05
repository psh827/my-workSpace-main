package com.varxyz.jv250.jdbc.banking;

import java.util.*;

public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String customerId;
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
	
	public Customer(long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	
	public long getCid() {
		return cid;
	}
	
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		return "이름: " + this.getName() + "\n주민번호: " + this.getSsn() + "\n핸드폰: " 
	+ this.getPhone() + "\n유저아이디: " + this.getCustomerId() + "\n패스워드 : " 
	+ this.getPasswd() + "\n";
	}


}
