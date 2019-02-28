package com.yammizzaa.fooddelivery.service;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Customer;

//Service class used by the clients to interact with the functionality of the application
//Interface is used just to show the functionality not the implementation to the clients
public interface CustomerService 
{
	//abstract methods called from the Customer controller class
	public void saveCustomer(Customer customer);
	
	public List<Customer> customerList();
	
	public  Customer getCustomerByEmail(String email);
	
	public String checkCustomerCredentials(Customer customer);
	
	

}
