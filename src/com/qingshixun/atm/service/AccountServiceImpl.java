package com.qingshixun.atm.service;

public class AccountServiceImpl extends AbstractAccount {

	/**
	 * 普通用户登录
	 */
	@Override
	public int login(String username, String password) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].getName().equals(username) && accounts[i].getPassword().equals(password)
					&& accounts[i].getIsVIP() == 0) {
				return i;

			}
		}
		return -1;
	}

	/**
	 * 普通账户余额查询
	 */
	@Override
	public double queryBalance(int accountIndex) {
		if (accounts[accountIndex].getIsVIP() == 0) {
			return accounts[accountIndex].getBalance();
		}
		return -1;
	}

	/**
	 * 普通用户存款
	 */
	@Override
	public double deposit(int accountIndex, double depositAccount) {
		if (accounts[accountIndex].getIsVIP() == 0) {
			double balance = accounts[accountIndex].getBalance();
			if (depositAccount <= 0) {
				return -1;
			} else {
				accounts[accountIndex].setBalance(balance + depositAccount);
				return accounts[accountIndex].getBalance();
			}
		}
		return -2;
	}

	/**
	 * 普通用户取款
	 */
	@Override
	public double withdraw(int accountIndex, double withdrawAccount) {
		if (accounts[accountIndex].getIsVIP() == 0) {
			double balance = accounts[accountIndex].getBalance();
			if (withdrawAccount <= 0) {
				return -1;
			} else {
				accounts[accountIndex].setBalance(balance - withdrawAccount);
				return accounts[accountIndex].getBalance();
			}
		}
		return -2;
	}

	/**
	 * 普通用户转账
	 */
	@Override
	public double transfer(int accountIndex, double transferAccount, String name) {
		if (accounts[accountIndex].getIsVIP() == 0) {
			for (int i = 0; i < accounts.length; i++) {
				if (accounts[i].getName().equals(name)) {
					if (accounts[accountIndex].getName().equals(name)) {
						return -1;
					} else if (accounts[accountIndex].getBalance() < transferAccount) {
						return -2;
					} else if (transferAccount <= 0) {
						return -4;
					} else {
						double balance = accounts[accountIndex].getBalance();
						accounts[accountIndex].setBalance(balance - transferAccount);
						double nextBalance = (accounts[i].getBalance() + transferAccount);
						accounts[i].setBalance(nextBalance);
						return accounts[accountIndex].getBalance();
					}
				}
			}
			return -3;
		}
		return -5;
	}

	/**
	 * 普通用户修改密码
	 */
	@Override
	public int changePassword(int accountIndex, String inputPssword, String newPassword) {
		if (accounts[accountIndex].getIsVIP() == 0) {
			if (accounts[accountIndex].getPassword().equals(inputPssword) && newPassword.equals(newPassword)) {
				accounts[accountIndex].setPassword(newPassword);
				return 0;
			}
			return -2;
		}
		return -1;
	}

}
