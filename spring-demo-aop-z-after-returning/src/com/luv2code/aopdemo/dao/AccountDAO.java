package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public AccountDAO() { }
	
	public AccountDAO(String name, String serviceCode) {
		this.name = name;
		this.serviceCode = serviceCode;
	}

	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account("Account 1", "A"));
		accounts.add(new Account("Account 2", "B"));
		accounts.add(new Account("Account 3", "C"));
		
		return accounts;
	}
		
}
