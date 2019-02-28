package com.yammizzaa.fooddelivery.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yammizzaa.fooddelivery.model.Driver;
import com.yammizzaa.fooddelivery.model.OrederFood;


//@Repository indicates that the class is DAO where methods perform operations over database
@Repository
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	// method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	Session session;
	Transaction tx;

	public void addorder(OrederFood order) {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		
			/*
			SQLQuery query=session.createSQLQuery("select phone from Driver where driver_id="+order.getDriverid());
			List<Object[]> list = new ArrayList<Object[]>();
			list = query.list();
			long phone = 0;
			if( list.size()!=0)
			{
				phone= (Long) list.get(0)[0];
			}

			order.setPhone(phone);
			session.update(order);
			*/
			// System.err.println("OrderDAOImpl.addorder()--->"+order.getPhone());
		order.setStatus("Pending");
		session.persist(order);
		tx.commit();
		session.close();
		//return "Order added";

	}

	
	public String deliverycheck(long phone) {
		try {
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			SQLQuery query = session.createSQLQuery("update Driver set Orderstatus='Available' where phone=" + phone);
			query.executeUpdate();
			SQLQuery queryy = session.createSQLQuery("update OrederFood set status='Delivered' where phone=" + phone);
			queryy.executeUpdate();
			session.flush();
			tx.commit();
			return "updated";
		} catch (Exception e) {
			System.err.println("exception=" + e.getMessage());
			tx.rollback();
			return "error";
		}

	}

	public List<OrederFood> orderlist() {

		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<OrederFood> orderList = session.createCriteria(OrederFood.class).list();
		tx.commit();
		session.close();
		return orderList;

	}

	public void orderassign(Integer id,long phone) {
		session = this.sessionFactory.openSession();
		tx = session.beginTransaction();
		session.createSQLQuery("update Driver set Orderstatus='Order Assigned' where phone=" + phone +" and Orderstatus='Available'" ).executeUpdate();
		session.createSQLQuery("update OrederFood set status='Pending' where order_id="+id).executeUpdate();
	    Query query= session.createSQLQuery("update OrederFood set phone='"+phone+"' where order_id="+id+"");
		query.executeUpdate();

		tx.commit();
		
		session.close();
		
		
	}

}
