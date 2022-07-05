package com.varxyz.banking.domain;
/**
 * 물흐르는대로 흘러가겠습니다.
 * @author 빡상.
 *
 */
public abstract class Account {
	private String accountNum;
	protected double balance;
	protected Customer customer;
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
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
	
}
