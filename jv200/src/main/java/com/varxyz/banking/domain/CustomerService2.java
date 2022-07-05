package com.varxyz.banking.domain;

import java.util.Collection;

public interface CustomerService2 {
		void addCustomer(Customer customer);
		Customer getCustomerBySsn(String ssn);
		Collection<Customer> getAllCustomers();
		int getNumOfCustomers();
}
