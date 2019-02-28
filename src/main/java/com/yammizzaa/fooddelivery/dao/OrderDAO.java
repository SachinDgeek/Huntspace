package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;


public interface OrderDAO 
{
	public void addorder(OrederFood order);

	public List<OrederFood> orderlist();

	public String deliverycheck(long phone);

	public void orderassign(Integer id, long phone);
}
