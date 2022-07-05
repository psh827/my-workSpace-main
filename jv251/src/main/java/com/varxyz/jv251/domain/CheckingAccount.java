package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.OverdraftAmountException;

public class CheckingAccount extends Account{
	private double overdraftAmount;
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}

	
	public CheckingAccount() {
		// TODO Auto-generated constructor stub
	}


	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
		}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
		}
	
	public void withdraw(double amount) throws OverdraftAmountException{
		if(balance < amount) {
			//잔고 부족 시 overdraftAmount 금액 한도 내에서 추가 출금을 승인.
			double overdraftNeeded = amount - balance;
				if(overdraftAmount < overdraftNeeded) { 
					//현재잔고보다 크고 현재잔고액을 제외한 금액이 한도대출액 보다 클 경우 예외처리.
					throw new OverdraftAmountException("에러 : 대월금 초과", balance, overdraftNeeded);
				}
				else {
					overdraftAmount -= (amount - balance);
					//마이너스 통장의 남은 한도를 조회 가능 하게 설정
					overdraftAmount	= overdraftAmount - overdraftNeeded; 
				}				
		}else {
			balance = balance - amount;
		}
	}
	
}
