package com.cg.mypayment.junittest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class TestClass {
WalletService service;
	
	@Before
	public void initData(){
		 Map<String,Customer> data= new HashMap<String, Customer>();
		 Customer cust1=new Customer("Amit", "9900112212",new Wallet(new BigDecimal(9000)));
		 Customer cust2=new Customer("Ajay", "9963242422",new Wallet(new BigDecimal(6000)));
		 Customer cust3=new Customer("Yogini", "9922950519",new Wallet(new BigDecimal(7000)));
				
		 data.put("9900112212", cust1);
		 data.put("9963242422", cust2);	
		 data.put("9922950519", cust3);	
			service= new WalletServiceImpl(data);
			
	}
	
	/*@Test
	public void testShowBal() throws SQLException {
		Customer customer1= new Customer();
		customer1=service.showBalance("9900112212");
		String bal = customer1.getWallet().getBalance().toString();
		assertEquals("9000",bal);
	}*/
	
	@Test (expected=NullPointerException.class)
	public void testCreateAccount() throws SQLException {
		service.createAccount(null, null, null);
	}
	
	@Test
	public void testCreateAccount2() throws SQLException {
		Customer cust = new Customer();
		cust=service.createAccount("Vamshi", "8568745614", new BigDecimal(4500));
		assertEquals("Vamshi",cust.getName());
	}
	
	@Test
	public void testCreateAccount3() throws SQLException {
		Customer cust = new Customer();
		cust=service.createAccount("Vamshi", "8568745614", new BigDecimal(4500));
		assertEquals("8568745614",cust.getMobileNo());
		
	}
	
	/*@Test (expected=InvalidInputException.class)
	public void testShowBalance() throws SQLException {
		Customer cust = new Customer();
		cust = service.showBalance("9875210023");
	}*/
	
	/*@Test
	public void testShowBalance2() throws SQLException {
		Customer cust = new Customer();
		
		cust = service.showBalance("9900112212");
		assertEquals(cust.getWallet().getBalance(), new Wallet(new BigDecimal(9000)));
	}*/
	
	
}
