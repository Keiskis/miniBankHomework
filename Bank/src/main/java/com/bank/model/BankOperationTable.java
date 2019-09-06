package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "USEROPERATIONS")
public class BankOperationTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long userId;
	private long deposit;
	private long withdrawal;
	private long balance;
	
    public BankOperationTable() {
    }
    
	public BankOperationTable (int userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

	public long getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(long withdrawal) {
		this.withdrawal = withdrawal;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
