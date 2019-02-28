package com.yammizzaa.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.Restaurant;

import com.yammizzaa.fooddelivery.service.RestaurantService;


//controller Restaurant class which gathers the input and execute the request related action method

@RestController
@RequestMapping(value="/restaurant")
public class RestaurantController 
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	RestaurantService restaurantservice;
	
	//request method to add the Restaurant details into the Restaurant table in database
	@RequestMapping(value = "/restaurantadd",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addRestaurant(@RequestBody Restaurant restaurant){
		return restaurantservice.addRestaurant(restaurant);
	}
	
	//request method to view Restaurant details from the Restaurant table in database
	@RequestMapping(value ="/restaurantget",method = RequestMethod.GET)
	public List<Restaurant> restaurantList(){
		return restaurantservice.Restaurantlist();
	}
	
	//request method to get particular restaurant details by providing restaurant id
	@RequestMapping(value="/restaurantgetbyid/{id}",method=RequestMethod.GET)
	  public Restaurant restaurantListbyId(@PathVariable Integer id)
	  {
		  return restaurantservice.getRestaurantById(id);
	  }
	

	//request method to delete the Restaurant details into the Restaurant table in database
	@RequestMapping(value = "/restaurantdelete",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteRestaurant(@RequestBody Restaurant restaurant){
		return restaurantservice.deleteRestaurant(restaurant.getR_id());
	}
	
	
	//request method to add the Restaurant details into the Restaurant table in database
		@RequestMapping(value = "/restaurantupdate",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public String updateRestaurant(@RequestBody Restaurant restaurant){
			return restaurantservice.updateRestaurant(restaurant.getName(),restaurant.getPhone(),restaurant.getAddress(),restaurant.getPrice(),restaurant.getImage(),restaurant.getProductList(),restaurant.getR_id());
		}
	
}
