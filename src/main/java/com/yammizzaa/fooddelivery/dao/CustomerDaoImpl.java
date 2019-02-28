package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yammizzaa.fooddelivery.model.Customer;
import com.yammizzaa.fooddelivery.model.Driver;

//@Repository indicates that the class is DAO where methods perform operations over database
@Repository
@Service
public class CustomerDaoImpl implements CustomerDao
{
	@Autowired
	private SessionFactory sessionFactory;

	// method to get session
	public void setSessionFactory(SessionFactory sessionFactory)
	{
	   this.sessionFactory = sessionFactory;
	}

	Session session;
	Transaction tx;
	
	// saving the customer
	public void saveCustomer(Customer customer)
	{
		session = this.sessionFactory.openSession();
		 tx = session.beginTransaction();
		session.persist(customer);
		tx.commit();
		session.close();
	}

	
	public Customer getCustomer(String email)
    {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria crit = session.createCriteria(Customer.class);
			crit.add(Restrictions.eq("email", email));
			@SuppressWarnings("unchecked")
			List<Customer> list = crit.list();
			System.err.println("ManageDAOImpl.CustomerDetails()-------------->" + list);
			return list.get(0);
		} catch (Exception e) {
			System.err.println("ManageDAOImpl.CustomerDetails()---------------> from catch :" + e);
			return null;
		} finally {
			session.close();
		}
    }


	//to retrieve the customer details from the database
	@SuppressWarnings("unchecked")
	public List<Customer> customerList()
	{
		 session = this.sessionFactory.openSession();
		 tx = session.beginTransaction();
		List<Customer> customerList = session.createCriteria(Customer.class).list();
		tx.commit();
		session.close();
		return customerList;
	}

	
	//to check the customer credentials correct or not
	public String checkCustomerCredentials(Customer customer) 
	{
		 session = this.sessionFactory.openSession();
		 tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select 1 from Customer where email='" + customer.getEmail()
				+ "' and password = '" + customer.getPassword() + "'");
		if (query.uniqueResult() != null)
		{
			return "success";
		} else 
		{
			return "failure";
		}

	}
}
