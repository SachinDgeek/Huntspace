package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Product;
import com.yammizzaa.fooddelivery.model.Restaurant;
import com.yammizzaa.fooddelivery.service.ProductService;

public interface RestaurantDao 
{
	public String addRestaurant(Restaurant restaurant);

	public List<Restaurant> getRestaurantList();

	public Restaurant getRestaurantbyid(int ID);
	
	public String deleteRestaurant(Integer r_id);
	

	public String updateRestaurant(String name, long phone, String address, Integer price, String image,
			List<Product> productList, Integer id);

}
