package com.varxyz.jv250.jdbc.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSOWRD = "jv250";
	
	public CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ---> " + JDBC_DRIVER);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 전체 고객 정보 조회
	 * @return
	 */
	public List<Customer> findAllCustomers(){
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSOWRD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setPasswd(rs.getString("passwd"));
					c.setCustomerId(rs.getString("customerId"));
					customerList.add(c);
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public Customer findCustomerBySsn(String ssn) {
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSOWRD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setPasswd(rs.getString("passwd"));
					c.setCustomerId(rs.getString("customerId"));
				}
				
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 신규 고객 등록
	 * @param customer 			등록할 고객정보
	 */
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone, customerId, passwd) "
				+ " VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSOWRD);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getCustomerId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.executeUpdate();
			
			System.out.println("INSERTED...");
			pstmt.close();
			con.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
