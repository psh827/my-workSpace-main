package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---> " + driver);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM Account";
		try (
				Connection con = DriverManager.getConnection(url, id, passwd);			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql); //DB로 가게되면 이 sql문을 파싱해서 자기의 구문으로 변환. 몇 건인지 모르기 때문에 while로 돌림
			) {
			System.out.println("CONNECTED TO ---> " + url);
			while(rs.next()) { //next()는 데이터를 가르킨다 데이터가 있으면 true 없으면 false
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overdraft = rs.getDouble("overdraft");
				char accountType = rs.getString("accountType").charAt(0);
				String customerId = rs.getString("customerId");
				String regDate = rs.getString("regDate");
				System.out.println(aid);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(accountType);
				System.out.println(overdraft);
				System.out.println(customerId);
				System.out.println(regDate);
				System.out.println("------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
