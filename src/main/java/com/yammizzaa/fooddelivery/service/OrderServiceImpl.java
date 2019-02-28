package com.yammizzaa.fooddelivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.dao.OrderDAO;
import com.yammizzaa.fooddelivery.model.OrederFood;

//Order Service implementation class which will not be given to the clients
//@Service used for automatic bean detection using class path
@Service
public class OrderServiceImpl implements OrderService
{
	// @Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	OrderDAO orderDAO;

	// @Transactional helps to interact with the database
	@Transactional
	public void orderadd(OrederFood order) {
		orderDAO.addorder(order);

	}

	public List<OrederFood> orderList() {

		return orderDAO.orderlist();
	}

	public String deliverycheck(long phone) {
		return orderDAO.deliverycheck(phone);
	}

	public void orderassign(Integer id, long phone) {
		orderDAO.orderassign(id,phone);
		
	}

}
