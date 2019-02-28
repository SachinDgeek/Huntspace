package com.yammizzaa.fooddelivery.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;
import com.yammizzaa.fooddelivery.service.OrderService;

//controller Order class which gathers the input and execute the request related action method
@RestController
@RequestMapping(value="/order")
public class OrderController 
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	OrderService orderservice;
	
	//request method to add the Order details into the Order table in database
	@RequestMapping(value = "/orderadd",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void orderadd(@RequestBody OrederFood order){
		orderservice.orderadd(order);
	}
	
	//request method to view Order details from the Order table in database
	@RequestMapping(value ="/orderget",method = RequestMethod.GET)
	public List<OrederFood> orderList(){
		return orderservice.orderList();
	}
	
	//request method to check whether the order by customer is delivered by driver or not 
	@RequestMapping(value = "/deliverycheck",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deliveryCheck(@RequestBody Driver driver){
		return orderservice.deliverycheck(driver.getPhone());
	}
	
	//request method to add the Order details into the Order table in database
		@RequestMapping(value = "/orderassign",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public void orderassign(@RequestBody OrederFood order){
			orderservice.orderassign(order.getId(),order.getPhone());
		}
		
}
