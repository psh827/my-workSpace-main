package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.domain.Account;

public class AccountService {
	private AccountDao accountDao;
	
	public AccountService(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	/**
	 * 신구 계좌 등록
	 * @param account  [SavingAccount | CheckingAccount]
	 */
	
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}
	
	public static void main(String[] args) {
		AccountService service = new AccountService(null);
		System.out.println(service.generateAccount());
	}
	
	/**
	 * XXX-XX-XXXX 형식의 계좌번호 생성.
	 * 
	 * @return
	 */
	public String generateAccount() {
		String numStr = String.valueOf((int)(Math.random() * 100000000));
		StringBuilder sb = new StringBuilder();
		sb.append(numStr.substring(0, 3));
		sb.append("-");
		sb.append(numStr.substring(3, 5));
		sb.append("-");
		sb.append(numStr.substring(5));
		
		return sb.toString();
	}
	
	public List<Account> getAllAccount(){
		return accountDao.findAllAccount();
	}
	
	public List<Account> getAccountBySsn(String ssn){
		return accountDao.findAccountsBySsn(ssn);
	}
	
	public Account getAccountByAccountNum(String accountNum){
		return accountDao.findAccountByAccountNum(accountNum);
	}
	
	public Account updateAccount(String accountNum, double money) {
		return accountDao.updateAccountBalance(accountNum, money);
	}
}
