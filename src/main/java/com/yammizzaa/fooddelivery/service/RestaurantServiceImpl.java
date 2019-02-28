package com.yammizzaa.fooddelivery.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.model.Customer;
import com.yammizzaa.fooddelivery.model.Product;
import com.yammizzaa.fooddelivery.model.Restaurant;
import com.yammizzaa.fooddelivery.dao.*;                        


//Restaurant Service implementation class which will not be given to the clients
//@Service used for automatic bean detection using class path
@Service
public class RestaurantServiceImpl implements RestaurantService
{
	// @Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	RestaurantDao RestaurantDao;

	// @Transactional helps to interact with the database
	@Transactional
	public List<Restaurant> Restaurantlist() {

		return RestaurantDao.getRestaurantList();
	}

	@Transactional
	public String addRestaurant(Restaurant restaurant) {
		return RestaurantDao.addRestaurant(restaurant);

	}

	public Restaurant getRestaurantById(Integer id) {
		return RestaurantDao.getRestaurantbyid(id);
	}

	public String deleteRestaurant(Integer r_id) {
		return RestaurantDao.deleteRestaurant(r_id);
	}

	public String updateRestaurant(String name, long phone, String address, Integer price, String image,
			List<Product> productList,Integer id) {
		return RestaurantDao.updateRestaurant(name,phone,address,price,image,productList,id);
	}
	
	
}
