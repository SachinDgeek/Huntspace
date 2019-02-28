package com.yammizzaa.fooddelivery.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.dao.ProductDAO;
import com.yammizzaa.fooddelivery.model.Product;

//Product Service implementation class which will not be given to the clients
//@Service used for automatic bean detection using class path

@Service
public class ProductServiceImpl implements ProductService
{
	// @Autowired used to automatic class dependency injection through spring bean configuration file
	@Autowired
	ProductDAO productDAO;

	// @Transactional helps to interact with the database
	@Transactional
	public void addProduct(Product product) {
		productDAO.addproduct(product);

	}

	public List<Product> getproductByRestId(int id) {

		return productDAO.productlistbyRestId(id);
	}

}
