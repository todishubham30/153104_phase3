package com.cg.mypaymentapp.repo;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mypaymentapp.beans.Customer;

public class WalletRepoImpl implements WalletRepo {
	
	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;

	public WalletRepoImpl() {
		super();
		 emf = Persistence.createEntityManagerFactory("ProjectAccount");
		 em = emf.createEntityManager();
		 tx = em.getTransaction();
	}

	@Override
	public boolean save(Customer customer) {
		tx.begin();
		em.persist(customer);
		tx.commit();
		
		return true;
	}

	@Override
	public Customer findOne(String mobileNo) throws SQLException {

		tx.begin();
		Customer customer = em.find(Customer.class, mobileNo);
		tx.commit();
		return customer;
	}

	@Override
	public void update(Customer customer) throws SQLException {

		tx.begin();
		em.persist(customer);
		tx.commit();
		
	}
}