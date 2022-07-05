package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.LackOfBalanceException;


public class SavingAccount extends Account{
	private double interestRate;
	
	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public SavingAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	
	public SavingAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}

	public void withdraw(double amount) throws LackOfBalanceException {
			if(balance - amount < 0) {
				//예외발생
				throw new LackOfBalanceException("잔고부족");
			}			
		super.balance -= amount;
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
