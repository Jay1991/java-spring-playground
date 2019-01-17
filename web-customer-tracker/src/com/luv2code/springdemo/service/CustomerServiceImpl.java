package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return this.customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer model) {
		this.customerDAO.saveCustomer(model);
	}

	@Override
	@Transactional
	public Customer getCustomerById(int customerId) {
		return this.customerDAO.getCustomerById(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		this.customerDAO.deleteCustomer(customer);
	}

}
