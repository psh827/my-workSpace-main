package com.varxyz.jv250.jdbc.banking;

import java.util.Date;

public class AccountDaoTest {
	public static void main(String[] args) {
		AccountDao dao = new AccountDao();
//		SavingAccount sa = new SavingAccount();
//		sa.setAccountNum("888-88-8888");
//		sa.setBalance(40000.0);
//		sa.setCustomer(new Customer(1004));
//		sa.setInterestRate(0.04);
//		sa.setRegDate(new Date());
//		sa.setAccountType('S');
//		
//		dao.addAccount(sa);
		for(Account a : dao.findAccountsBySsn("961025-1234567")) {
			System.out.println(a.toString());
		};
//		Account a = new SavingAccount("531-24-7851", 1421.0, 0.052);
		
//		a.setCustomer(dao.findCustomerBySsn("991215-1242015"));
		
//		aDao.addAccount(a);
		for(Account a : dao.findAllAccount()) {
			System.out.println(a.toString());
		}
		
		
	}
}
