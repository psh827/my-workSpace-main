package com.varxyz.jv250.jdbc.banking;

import java.util.Date;

/**
 * 물흐르는대로 흘러가겠습니다.
 * @author 빡상.
 *
 */
public abstract class Account {
	protected String accountNum;
	protected long aid; 
	protected char accountType;
	protected long customerId;
	protected double balance;
	protected Customer customer;
	protected Date regDate;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getAccountNum() {
		return accountNum;
	}


	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public void deposite(double amount) {
		this.balance += amount;
	}
	
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", accountNum=" + accountNum 
				+ ", balance=" + balance + ", accountType=" + accountType + ", customer=[" + getCustomer().getCid()
				+ "," + getCustomer().getName() + ", " + getCustomer().getSsn() + ", " +
				getCustomer().getPhone() + "], regDate=" + getRegDate(); 

	}
	
}
