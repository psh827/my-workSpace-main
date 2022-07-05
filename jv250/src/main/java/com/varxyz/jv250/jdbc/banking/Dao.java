package com.varxyz.jv250.jdbc.banking;

public class Dao {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSOWRD = "jv250";
	
	private static Dao dao = new Dao();
	
	private Dao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ---> " + JDBC_DRIVER);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Dao getDao() {
		return dao;
	}
}
