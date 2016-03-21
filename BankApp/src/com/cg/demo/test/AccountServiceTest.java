package com.cg.demo.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.demo.beans.Account;
import com.cg.demo.beans.Customer;
import com.cg.demo.exceptions.InvalidInitialAmountException;
import com.cg.demo.repo.AccountRepoInMemoryImpl;
import com.cg.demo.service.AccountService;
import com.cg.demo.service.AccountServiceImpl;


public class AccountServiceTest {
	
	private AccountService service;
	
	@Before
	public void init(){
		
		service= new AccountServiceImpl(new AccountRepoInMemoryImpl());
	}
/*************************
 *  Test cases for createAccount
 * **********************/
	// Customer object reference should not be null
	// Customer name should not be null
	// Amount should be greater than 500
	// Account object reference which is returned by the createAccount method shouldn't be null
	// Account should be create successfully
	
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void test_customer_object_reference(){
		
		Customer c = null;
		try {
			service.createAccount(c, 1000);
		} catch (InvalidInitialAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected=java.lang.IllegalArgumentException.class)
	public void test_customer_name(){
		Customer c = new Customer();
		try {
			service.createAccount(c, 1000);
		} catch (InvalidInitialAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(expected=com.cg.demo.exceptions.InvalidInitialAmountException.class)
	public void test_amount_greater_than_500() throws InvalidInitialAmountException{
		
		Customer c = new Customer("Ankur");
			service.createAccount(c, 100);
		
	}
	
	@Test
	public void test_createAccount(){
		Customer c = new Customer("Ankur");
		try {
			Account a= service.createAccount(c, 1000);
			assertEquals(a.getBalance()+"", 1000.00+"");
		} catch (InvalidInitialAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
/*************************************************
 *  Test cases for showBalance	
 */
	// Account number should be valid
	// It should return balance for valid accounts
	
/**********************************************************
 * 
 *  Test cases for withdraw	
 */
	
	// Account number should be valid
	// amount passed should not be negative
	// Minimum Rs. 500 balance should be maintained in the account 
	// if account number and amount are valid then it should deduct the balance.
	
/*
 * Test cases for deposit
 */
	
	// Account should be valid
	// amount should not be greater than zero
	// After deposit balance should be increased.
	
	

}












