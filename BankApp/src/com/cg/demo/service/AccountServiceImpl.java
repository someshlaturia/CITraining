package com.cg.demo.service;

import com.cg.demo.beans.Account;
import com.cg.demo.beans.Customer;
import com.cg.demo.exceptions.InsufficientBalanceException;
import com.cg.demo.exceptions.InvalidAccountException;
import com.cg.demo.exceptions.InvalidInitialAmountException;
import com.cg.demo.repo.AccountRepo;
import com.cg.demo.util.AccountNumberGenerator;

public class AccountServiceImpl implements AccountService {
	
	private AccountRepo repo;

	public AccountServiceImpl(AccountRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Account createAccount(Customer c, float amount)
			throws InvalidInitialAmountException {
		if(c== null){
			throw new IllegalArgumentException("Customer cannot be null");
		}
		
		if(c.getName()== null){
			throw new IllegalArgumentException("Customer name cannot be null");
		}
		
		if(amount <500){
			throw new InvalidInitialAmountException();
		}
		Account a = new Account(AccountNumberGenerator.getNumber());
		a.setBalance(amount);
		a.setCustomer(c);
		if(repo.save(a)){
			return a;
		}
		return null;
	}

	@Override
	public double showBalance(int number) throws InvalidAccountException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Account withdraw(int number, float amount)
			throws InvalidAccountException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account deposit(int number, float amount)
			throws InvalidAccountException {
		// TODO Auto-generated method stub
		return null;
	}

}
