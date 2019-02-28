package com.yammizzaa.fooddelivery.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.model.Product;

//@Repository indicates that the class is DAO where methods perform operations over database
@Repository
@Service
public class ProductDAPImpl implements ProductDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	// method which provide session
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;
	Transaction tx;

	// method to add product details into database
	public void addproduct(Product product) {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		session.persist(product);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	public List<Product> productlistbyRestId(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Object[]> items = session.createSQLQuery("select name,price from Product where restaurant_id=" + id)
				.list();
		System.err.println("productlistbyRestId()---->" + items);
		List<Product[]> productlist = new ArrayList();
		System.err.println("productlistbyRestId()---->" + items);
		List<Product> list = new ArrayList();
		Map<String, Integer> mapResult = new LinkedHashMap<String, Integer>();
		for (Object[] obj : items) {
			Product product = new Product();
			product.setName((String) obj[0]);
			product.setPrice((Integer) obj[1]);
			list.add(product);
		}
		tx.commit();
		session.close();
		return list;
	}

}
