package com.qingshixun.atm.service;

public class VIPAccountServiceImpl extends AbstractAccount {

	/**
	 * VIP用户登录
	 */
	@Override
	public int login(String username, String password) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getName().equals(username) && accounts[i].getPassword().equals(password)
					&& accounts[i].getIsVIP() == 1) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * VIP账户余额查询
	 */
	@Override
	public double queryBalance(int accountIndex1) {
		if (accounts[accountIndex1].getIsVIP() == 1) {
			return accounts[accountIndex1].getBalance();
		}
		return -1;
	}

	/**
	 * VIP存款
	 */
	@Override
	public double deposit(int accountIndex1, double depositAccount) {
		if (accounts[accountIndex1].getIsVIP() == 1) {
			double balance = accounts[accountIndex1].getBalance();
			if (depositAccount <= 0) {
				return -1;
			} else {
				accounts[accountIndex1].setBalance(balance + depositAccount);
				return accounts[accountIndex1].getBalance();
			}
		}
		return -2;
	}

	/**
	 * VIP取款
	 */
	@Override
	public double withdraw(int accountIndex1, double withdrawAccount) {
		if (accounts[accountIndex1].getIsVIP() == 1) {
			double balance = accounts[accountIndex1].getBalance();
			if (withdrawAccount <= 0) {
				return -1;
			} else {
				accounts[accountIndex1].setBalance(balance - withdrawAccount);
				return accounts[accountIndex1].getBalance();
			}
		}
		return -2;
	}

	/**
	 * VIP转账
	 */
	@Override
	public double transfer(int accountIndex1, double transferAccount, String name) {
		if (accounts[accountIndex1].getIsVIP() == 1) {
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getName().equals(name)) {
					if (accounts[accountIndex1].getName().equals(name)) {
						return -1;
					} else if (accounts[accountIndex1].getBalance() < transferAccount) {
						return -2;
					} else if (transferAccount <= 0) {
						return -4;
					} else {
						double balance = accounts[accountIndex1].getBalance();
						accounts[accountIndex1].setBalance(balance - transferAccount);
						double nextBalance = (accounts[i].getBalance() + transferAccount);
						accounts[i].setBalance(nextBalance);
						return accounts[accountIndex1].getBalance();
					}
				}
			}
			return -3;
		}
		return -5;
	}

	/**
	 * VIP修改密码
	 */
	@Override
	public int changePassword(int accountIndex1, String inputPssword, String newPassword) {
		if (accounts[accountIndex1].getIsVIP() == 1) {
			if (accounts[accountIndex1].getPassword().equals(inputPssword) && newPassword.equals(newPassword)) {
				accounts[accountIndex1].setPassword(newPassword);
				return 0;
			}
			return -2;
		}
		return -1;
	}
}
