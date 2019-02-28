package com.yammizzaa.fooddelivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yammizzaa.fooddelivery.model.Product;
import com.yammizzaa.fooddelivery.service.ProductService;


//controller Product class which gathers the input and execute the request related action method

@RestController
@RequestMapping(value="/product")
public class ProductController 
{
	//@Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	ProductService productservice;
	
	//request method to get particular restaurant products details by providing restaurant id
	@RequestMapping(value="/productgetbyrestid/{id}",method=RequestMethod.GET)
	  public List<Product> productdetails(@PathVariable int id)
	  {
		  return productservice.getproductByRestId(id);
	  }
	
}
