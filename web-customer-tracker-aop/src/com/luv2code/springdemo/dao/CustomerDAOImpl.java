package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		return this
			.sessionFactory
			.getCurrentSession()
			.createQuery("from Customer order by firstName", Customer.class)
			.getResultList();
	}

	@Override
	public void saveCustomer(Customer model) {
		this
			.sessionFactory
			.getCurrentSession()
			.saveOrUpdate(model);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return this
			.sessionFactory
			.getCurrentSession()
			.get(Customer.class, customerId);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		this.sessionFactory.getCurrentSession().delete(customer);
	}

}
