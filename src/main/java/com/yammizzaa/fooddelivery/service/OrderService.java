package com.yammizzaa.fooddelivery.service;

import java.util.List;

import com.yammizzaa.fooddelivery.model.OrederFood;

//Service class used by the clients to interact with the functionality of the application
//Interface is used just to show the functionality not the implementation to the clients
public interface OrderService 
{
	//abstract methods called from the Order controller class
	public void orderadd(OrederFood order);

	public List<OrederFood> orderList();

	public String deliverycheck(long phone);

	public void orderassign(Integer id, long phone);
}
