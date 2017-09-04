package com.qingshixun.atm.service;

import com.qingshixun.atm.model.Account;

public abstract class AbstractAccount implements AccountService {

	// 银行账户
	protected static Account[] accounts = new Account[4];

	/**
	 * 初始化账户信息，用户数组模拟数据库，储存账户信息
	 */
	public void initAccounts() {
		// 第一个账户
		Account account1 = new Account();
		account1.setName("pan");
		account1.setPassword("123");
		account1.setBalance(1000);
		account1.setIsVIP(0);
		accounts[0] = account1;

		// 第二个账户
		Account account2 = new Account();
		account2.setName("panshuai");
		account2.setPassword("456");
		account2.setBalance(2000);
		account2.setIsVIP(0);
		accounts[1] = account2;
		
		//VIP第一个账户
		Account account3 = new Account();
		account3.setName("shuai");
		account3.setPassword("456");
		account3.setBalance(5000);
		account3.setIsVIP(1);
		accounts[2] = account3;
		
		//VIP第二个账户
		Account account4 = new Account();
		account4.setName("shuaipan");
		account4.setPassword("123");
		account4.setBalance(10000);
		account4.setIsVIP(1);
		accounts[3] = account4;
	}
}
