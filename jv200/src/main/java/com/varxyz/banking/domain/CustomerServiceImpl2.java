package com.varxyz.banking.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerServiceImpl2 implements CustomerService2{
	private List<Customer> customerList = new ArrayList<Customer>();

	public void addCustomer(Customer customer) {
		if(getCustomerBySsn(customer.getSsn()) == null) {
			customerList.add(customer);
			System.out.println("성공");
		}
	}

	public Customer getCustomerBySsn(String ssn) {
		for(Customer c: customerList) {
			if(ssn.equals(c.getSsn())){
				return c;
			}
		}
		return null;
	}

	public Collection<Customer> getAllCustomers() {
		return customerList;
	}

	public int getNumOfCustomers() {
		return customerList.size();
	}}
