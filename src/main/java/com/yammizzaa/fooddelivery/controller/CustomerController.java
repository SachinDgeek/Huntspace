package com.yammizzaa.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yammizzaa.fooddelivery.model.Customer;
import com.yammizzaa.fooddelivery.service.CustomerService;

//controller Customer class which gathers the input and execute the request related action method

@RestController
@RequestMapping(value="/customer")
public class CustomerController 
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	CustomerService customerService;
	
	//request method to add the Customer details into the Customer table in database
	@RequestMapping(value = "/customeradd",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCustomer(@RequestBody Customer customer){
		customerService.saveCustomer(customer);
	}
	
	//request method to view Customer details from the Customer table in database
	@RequestMapping(value ="/customerget",method = RequestMethod.GET)
	public List<Customer> customerList(){
		return customerService.customerList();
	}
	
	//request method to check Customer credentials entered are correct or not to login into application
	@RequestMapping(value = "/customercheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String customercheck(@RequestBody Customer customer) {
		return customerService.checkCustomerCredentials(customer);
	}

	//request method to get particular customer details by providing email
	@RequestMapping(value = "/getcustomerbyemail", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomerbyemail(@RequestParam("email") String email) {
		return customerService.getCustomerByEmail(email);
	}
		  
}