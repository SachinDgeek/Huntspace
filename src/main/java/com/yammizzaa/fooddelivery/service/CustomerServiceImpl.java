package com.yammizzaa.fooddelivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.model.Customer;
import com.yammizzaa.fooddelivery.dao.CustomerDao;

//Customer Service implementation class which will not be given to the clients
//@Service used for automatic bean detection using class path

@Service
public class CustomerServiceImpl implements CustomerService {

	// @Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	CustomerDao customerDao;

	// @Transactional helps to interact with the database
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);

	}

	@Transactional
	public List<Customer> customerList() {

		return customerDao.customerList();
	}

	public Customer getCustomerByEmail(String email) {

		return customerDao.getCustomer(email);
	}

	public String checkCustomerCredentials(Customer customer) {
		return customerDao.checkCustomerCredentials(customer);

	}

}
