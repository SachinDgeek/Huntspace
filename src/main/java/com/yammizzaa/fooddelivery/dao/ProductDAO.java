package com.yammizzaa.fooddelivery.dao;


import java.util.List;


import com.yammizzaa.fooddelivery.model.Product;

public interface ProductDAO
{
	public void addproduct(Product product);

	public List<Product> productlistbyRestId(int id);
	
	
}
