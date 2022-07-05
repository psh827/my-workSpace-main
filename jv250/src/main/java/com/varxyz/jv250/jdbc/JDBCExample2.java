package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		PreparedStatement stmt = null;
		ResultSet rs =null;
		Connection con = null;
		
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER ---> " + driver);
			
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("CONNECTED TO ---> " + url);
			
			String sql = "SELECT * FROM Customer WHERE name = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "유비");
			rs = stmt.executeQuery(); //DB로 가게되면 이 sql문을 파싱해서 자기의 구문으로 변환. 몇 건인지 모르기 때문에 while로 돌림
			while(rs.next()) { //next()는 데이터를 가르킨다 데이터가 있으면 true 없으면 false
				long cid = rs.getLong("cid");
				String customerId = rs.getString("customerId");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				System.out.println(cid);
				System.out.println(customerId);
				System.out.println(name);
				System.out.println(phone);
				System.out.println("------------------------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (stmt != null) try { stmt.close(); } catch(SQLException ex) {}
			if (con != null) try { con.close(); } catch(SQLException ex) {}
		}
	}
}
