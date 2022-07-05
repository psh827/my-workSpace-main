package com.varxyz.jv250.jdbc.banking;

public class SavingAccount extends Account{
	private static final double DEFAULT_INTEREST_RATE = 0.03;
	private double interestRate;
	
	public SavingAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFAULT_INTEREST_RATE);
	}
	
	public SavingAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}

	public SavingAccount() {
		// TODO Auto-generated constructor stub
	}

	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public void withdraw(double amount) {
		try {
			if(balance - amount < 0) {
				//예외발생
				throw new LackOfBalanceException("잔고부족");
			}			
		} catch (LackOfBalanceException e) {
			System.out.println(e.getMessage());
		}
		super.balance -= amount;
	}
}
