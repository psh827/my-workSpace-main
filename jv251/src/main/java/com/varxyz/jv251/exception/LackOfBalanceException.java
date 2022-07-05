package com.varxyz.jv251.exception;

public class LackOfBalanceException extends RuntimeException{
	private double balance;
	
	public LackOfBalanceException(String msg) {
		super(msg);
	}
	
	public LackOfBalanceException(String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + " 현재 잔고는 " + balance + " 입니다.";
	}
}
