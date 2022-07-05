package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceTest {
	public static void main(String[] args) {
		CustomerService2 customer = new CustomerServiceImpl2();
		Customer park = new Customer();
		park.setName("pakr");
		park.setSsn("960827-123456");
		park.setPasswd("tkdgns");
		customer.addCustomer(park);
		System.out.println(customer.getCustomerBySsn("960827-123456"));
		
		AccountService as = AccountServiceImpl.getInstance();
		List<Account> acc = new ArrayList<Account>();
		
		as.addAccount(new SavingAccount("3333-09-6233716", 7.5), "960827-123456");
		System.out.println(as.getAccountByAccountNum("3333-09-6233-716"));
		System.out.println(as.getAccountBySsn("960827-123456"));
		
		
	}
	
}
