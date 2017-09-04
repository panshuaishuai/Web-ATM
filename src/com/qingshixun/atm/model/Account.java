package com.qingshixun.atm.model;

/**
 * 账户实体类
 * 
 * @author panshuai
 *
 */
public class Account {

	private String name;
	private String password;
	private double balance;
	private int isVIP;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getIsVIP() {
		return isVIP;
	}

	public void setIsVIP(int isVIP) {
		this.isVIP = isVIP;
	}

	
}
