package com.yammizzaa.fooddelivery.service;

import java.util.List;

//Service class used by the clients to interact with the functionality of the application
//Interface is used just to show the functionality not the implementation to the clients
import com.yammizzaa.fooddelivery.model.Product;


public interface ProductService 
{
	//abstract methods called from the Product controller class
	public void addProduct(Product product);

	public List<Product> getproductByRestId(int id);
}
