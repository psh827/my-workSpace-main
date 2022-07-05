package com.varxyz.jv250.jdbc.banking;

import java.util.List;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
		//findAllCustomers() Test
		List<Customer> customerList = dao.findAllCustomers();
		for(Customer customer: customerList) {
			System.out.println(customer.toString());
		}
		
		System.out.println(dao.findCustomerBySsn("991215-1242015"));
		
//		Customer c = new Customer();
//		c.setName("제갈량");
//		c.setSsn("991215-1242015");
//		c.setPhone("010-9876-5432");
//		c.setCustomerId("C");
//		c.setPasswd("7777");
//		
//		dao.addCustomer(c);
	}
}
