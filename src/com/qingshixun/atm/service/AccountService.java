package com.qingshixun.atm.service;

/**
 * 账户接口类
 * 
 * @author panshuai
 *
 */
public interface AccountService {

	void initAccounts();

	int login(String username, String password);

	double queryBalance(int accountIndex);

	double deposit(int accountIndex, double depositAccount);

	double withdraw(int accountIndex, double withdrawAccount);

	double transfer(int accountIndex, double transferAccount, String name);

	int changePassword(int accountIndex, String inputPssword, String newPassword);
}
