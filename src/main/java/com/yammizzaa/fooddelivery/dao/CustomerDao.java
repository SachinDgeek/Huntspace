package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Customer;

public interface CustomerDao
{

	void saveCustomer(Customer customer);
	
	public List<Customer> customerList();
	
	public Customer getCustomer(String email);
	
	public String checkCustomerCredentials(Customer customer);
	
	
	
}
