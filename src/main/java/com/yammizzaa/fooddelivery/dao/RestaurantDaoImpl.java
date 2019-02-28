package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.model.Product;
import com.yammizzaa.fooddelivery.model.Restaurant;
//import org.hibernate.query.NativeQuery; 
 


//@Repository indicates that the class is DAO where methods perform operations over database
@Repository
@Service
public class RestaurantDaoImpl implements RestaurantDao
{
	@Autowired
	private SessionFactory sessionFactory;

	// method which provides session
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	Session session;
	Transaction tx;

	// method to add restaurant details into database
	public String addRestaurant(Restaurant restaurant) {
		try {
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(restaurant);
			for (int i = 0; i < restaurant.getProductList().size(); i++) {
				restaurant.getProductList().get(i).setRestaurant(restaurant);
				session.save(restaurant.getProductList().get(i));
			}

			tx.commit();
			return "restaurant added successfully";
		} catch (Exception e) {
			tx.rollback();
			return "Entered Restaurant details already exists";
		} finally {
			session.close();
		}
	}

	// method to get restaurant list
	@SuppressWarnings("unchecked")
	public List<Restaurant> getRestaurantList() {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Restaurant> restaurantsList = session.createCriteria(Restaurant.class).list();
		for (int i = 0; i < restaurantsList.size(); i++) {
			restaurantsList.get(i).setProductList(null);
		}
		tx.commit();
		session.close();
		return restaurantsList;
	}

	public Restaurant getRestaurantbyid(int Id) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			return (Restaurant) session.get(Restaurant.class, Id);
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public String deleteRestaurant(Integer r_id) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.createSQLQuery("delete from Product where restaurant_id= "+r_id+"").executeUpdate();
        session.createSQLQuery("delete from Restaurant where restaurant_id = "+r_id+"").executeUpdate();
        tx.commit();
        session.close();
        return "deleted successfully";


	}

	public String updateRestaurant(String name, long phone, String address, Integer price, String image,
			List<Product> productList,Integer id) {
        Session session = this.sessionFactory.openSession();
        
        Transaction tx = session.beginTransaction();

        Restaurant restaurant = (Restaurant) session.get(Restaurant.class,id);
        restaurant.setAddress(address);
        restaurant.setImage(image);
        restaurant.setName(name);
        restaurant.setPhone(phone);
        restaurant.setPrice(price);
        restaurant.getR_id();
restaurant.setProductList(productList);
        tx.commit();
        session.close();
        return " Record Update Successfull..";

	}

}
