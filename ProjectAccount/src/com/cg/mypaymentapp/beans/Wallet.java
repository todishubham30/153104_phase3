package com.cg.mypaymentapp.beans;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
	
	@Id
	private int walletid;
	private BigDecimal balance;
	
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Wallet(int walletid, BigDecimal balance) {
		super();
		this.walletid = walletid;
		this.balance = balance;
	}



	public int getWalletid() {
		return walletid;
	}

	public void setWalletid(int walletid) {
		this.walletid = walletid;
	}

	public Wallet(BigDecimal amount) {
		this.balance = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return ", balance=" + balance;
	}

}