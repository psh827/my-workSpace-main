package com.varxyz.jv251.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingAccount;

public class AccountDao {
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, balance, interestRate, "
				+ " overdraft, accountType, customerId) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if(account instanceof SavingAccount) {
					SavingAccount sa = (SavingAccount) account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf(sa.getAccountType()));
					System.out.println("INSERTED...");
				} else if(account instanceof CheckingAccount) {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf(ca.getAccountType()));
					pstmt.executeUpdate();
					System.out.println("INSERTED...");
				}		
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			} finally {
				DataSourceManager.close(pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Account updateAccountBalance(String accountNum, double balance) {
		String sql = "UPDATE Account SET balance = ? WHERE accountNum = ?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, balance);
				pstmt.setString(2, accountNum);
				pstmt.executeUpdate();
				System.out.println("업데이트 완료");
			} finally {
				DataSourceManager.close(pstmt, con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Account findAccountByAccountNum(String accountNum) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, "
				+ "a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate "
				+ "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid\r\n"
				+ "WHERE a.accountNum = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();
				Account account = null;
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingAccount(sql, 0);
						((SavingAccount)account).setInterestRate(
								rs.getDouble("interestRate"));
						account.setAccountType(rs.getString("accountType").charAt(0));
					} else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraftAmount(
								rs.getDouble("overdraft"));
						account.setAccountType(rs.getString("accountType").charAt(0));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), 
							rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					return account;
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Account> findAccountsBySsn(String ssn){
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, "
				+ "a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate "
				+ "FROM Account a INNER JOIN Customer c ON a.customerId = c.cid\r\n"
				+ "WHERE c.ssn = ?";
		List<Account> list = new ArrayList<>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				Account account = null;
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingAccount(sql, 0);
						((SavingAccount)account).setInterestRate(
								rs.getDouble("interestRate"));
						account.setAccountType(rs.getString("accountType").charAt(0));
					} else {
						account = new CheckingAccount();
						((CheckingAccount)account).setOverdraftAmount(
								rs.getDouble("overdraft"));
						account.setAccountType(rs.getString("accountType").charAt(0));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("accountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"), 
							rs.getString("ssn"), rs.getString("phone")));
					account.setRegDate(rs.getTimestamp("regDate"));
					list.add(account);
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Account> findAllAccount(){
		String sql = "SELECT * FROM Account";
		List<Account> AccountList = new ArrayList();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				Account a = null;
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						a = new SavingAccount();
						a.setAccountType('S');
						a.setAid(rs.getLong("aid"));
						a.setAccountNum(rs.getString("accountNum"));
						a.setBalance(rs.getDouble("balance"));
						((SavingAccount)a).setInterestRate(rs.getDouble("interestRate"));
						AccountList.add(a);
					} else {
						a = new CheckingAccount();
						a.setAccountType('C');
						a.setAid(rs.getLong("aid"));
						a.setAccountNum(rs.getString("accountNum"));
						a.setBalance(rs.getDouble("balance"));
						((CheckingAccount)a).setOverdraftAmount(rs.getDouble("balance"));
						AccountList.add(a);
					}
				}
				
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return AccountList;
	}
}
