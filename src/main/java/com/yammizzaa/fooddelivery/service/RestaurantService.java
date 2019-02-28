package com.yammizzaa.fooddelivery.service;

import java.util.List;

import com.yammizzaa.fooddelivery.model.Product;
import com.yammizzaa.fooddelivery.model.Restaurant;

//Service class used by the clients to interact with the functionality of the application
//Interface is used just to show the functionality not the implementation to the clients
public interface RestaurantService 
{
	//abstract methods called from the Restaurant controller class
	public String addRestaurant(Restaurant restaurant);

	public List<Restaurant> Restaurantlist();

	public Restaurant getRestaurantById(Integer id);

	public String deleteRestaurant(Integer r_id);

	public String updateRestaurant(String name, long phone, String address, Integer price, String image,
			List<Product> productList, Integer id);


}
