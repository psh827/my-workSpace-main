package com.varxyz.banking.domain;

import java.util.*;

import com.varxyz.banking.domain.Customer;

public interface CustomerService {
	void addCustomer(Customer customer);
	Customer getCustomerBySsn(String ssn);
	Collection<Customer> getAllCustomers();
	int getNumOfCustomers();
}
