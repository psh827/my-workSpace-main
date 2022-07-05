package com.varxyz.jv250.jdbc.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountJdbcTest {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---> " + driver);	
			
			Connection con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---> " + url);
			
			select(con);
			insert(con);
			select(con);
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select(Connection con) {
		String sql = "SELECT * FROM Account";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) { //next()는 데이터를 가르킨다 데이터가 있으면 true 없으면 false
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum");
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overdraft = rs.getDouble("overdraft");
				char accountType = rs.getString("accountType").charAt(0);
				System.out.println(aid);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(accountType);
				System.out.println(overdraft);
				System.out.println("------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insert(Connection con) {
		String sql = "INSERT INTO Account (accountNum, balance, interestRate," + 
					" overdraft, accountType, customerId)" 
					+ " VALUES (?, ?, ?, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  "555-55-5555");
			pstmt.setDouble(2, 3000.0);
			pstmt.setDouble(3, 0.03);
			pstmt.setDouble(4, 0.0);
			pstmt.setString(5, String.valueOf('S'));
			pstmt.setLong(6, 1001);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("NEW ACCOUNT INSERTED>>>\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
