package com.varxyz.banking.domain;

public class AccountTest {
	public static void main(String[] args) {
		Account s = new SavingAccount();
		s.deposite(1000.0);
		SavingAccount s1 = (SavingAccount) s;
		s1.withdraw(900.0);
		System.out.println(s1.balance);
		
		Account c = new CheckingAccount();
		c.deposite(1500.0);
		CheckingAccount c1 = (CheckingAccount)c;
		c1.setOverdraftAmount(1000.0);
		c1.withdraw(1800.0);
		System.out.println(c1.balance);
	}
}
