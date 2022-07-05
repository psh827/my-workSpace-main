package com.varxyz.banking.domain;

import java.util.Collection;
import java.util.List;

public interface AccountService {
	void addAccount(Account account);
	void addAccount(Account account, String ssn);
	List<Account> getAccountBySsn(String ssn);
	Account getAccountByAccountNum(String accountNum);
	Collection<Account> getAllAccounts();
	int getNumOfAccounts();
}
