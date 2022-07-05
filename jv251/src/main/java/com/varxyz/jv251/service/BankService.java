package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.dao.AccountDao;
import com.varxyz.jv251.dao.CustomerDao;
import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingAccount;
import com.varxyz.jv251.exception.CustomerNotFoundException;
import com.varxyz.jv251.exception.DuplicatedEntityException;
import com.varxyz.jv251.exception.EntityNotFoundException;
import com.varxyz.jv251.exception.PasswordException;

public class BankService {
	public static final BankService service = new BankService();
	public static final char SA = 'S';
	public static final char CA = 'C';
	
	public static final double DEFAULT_INTEREST_RATE = 0.03;
	public static final double DEFAULT_OVERDRAFT_AMOUNT = 1000.0;
	
	private CustomerService customerService;
	private AccountService accountService;
	
	private BankService() {
		init();
	}
	
	public void init() {
		customerService = new CustomerService(new CustomerDao());
		accountService = new AccountService(new AccountDao());
	}
	
	public static BankService getInstance() {
		return service;
	}
	
	public void addCustomer(String name, String ssn, String phone, 
			String userId, String passwd) {
		if(!isCustomer(ssn)) {
			customerService.addCustomer(customerService
					.createCustomer(name, ssn, phone, userId, passwd));
		}
		throw new DuplicatedEntityException(ssn + " is duplicated.");
	}
	
	public Customer getCustomerBySsn(String ssn) {
		return customerService.getCustomerBySsn(ssn);
	}
	
	public List<Customer> getAllcustomers(){
		return customerService.getAllcustomers();
	}
	
	public void addSavingAccount(double balance, double interestRate, String ssn)
												throws CustomerNotFoundException{
		SavingAccount account = new SavingAccount();
		account.setAccountNum(accountService.generateAccount());
		account.setBalance(balance);
		account.setAccountType(BankService.SA);
		account.setInterestRate(interestRate);
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);	
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + " not found");
		}
	}
	
	public void addCheckingAccount(double balance, double overdraftAmount, String ssn) 
										throws CustomerNotFoundException{
		CheckingAccount account = new CheckingAccount();
		account.setAccountNum(accountService.generateAccount());
		account.setBalance(balance);
		account.setAccountType(BankService.CA);
		account.setOverdraftAmount(overdraftAmount);
		
		Customer customer = customerService.getCustomerBySsn(ssn);
		if(customer != null) {
			account.setCustomer(customer);	
			accountService.addAccount(account);
		}else {
			throw new CustomerNotFoundException(ssn + " not found");
		}
	}
	
	public void withDraw(String accountNum, String passwd, double money) throws PasswordException {
		Account account = accountService.getAccountByAccountNum(accountNum);
		String customerPasswd = account.getCustomer().getPasswd();
		if(account.getCustomer().getSsn().equals(customerPasswd)) {
			if(account instanceof SavingAccount) {
				SavingAccount sa = (SavingAccount) account;
				sa.withdraw(money);
				accountService.updateAccount(accountNum, sa.getBalance());
			}else {
				CheckingAccount ca = (CheckingAccount) account;
				ca.withdraw(money);
				accountService.updateAccount(accountNum, ca.getBalance());
			}			
		}else {
			throw new PasswordException("패스워드 오류");
		}
		
	}
	
	public void diposit(String accountNum, double money) {
		Account account = accountService.getAccountByAccountNum(accountNum);
		account.deposite(money);
		accountService.updateAccount(accountNum, account.getBalance());
	}
	
	public boolean isCustomer(String ssn) {
		return customerService.getCustomerBySsn(ssn) == null ? false : true;
	}
	
	public List<Account> getAccountBySsn(String ssn){
		return accountService.getAccountBySsn(ssn);
	}
	
	public List<Account> getAllAccount(){
		return accountService.getAllAccount();
	}
	
}
