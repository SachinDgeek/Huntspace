package com.yammizzaa.fooddelivery.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yammizzaa.fooddelivery.model.Admin;


//@Repository indicates that the class is DAO where methods perform operations over database
@Repository
public class AdminDAOImpl implements AdminDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	// method which provide me session
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	// saving the customer
	public void addadmin(Admin admin) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(admin);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Admin> adminlist() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Admin> adminList = session.createCriteria(Admin.class).list();
		tx.commit();
		session.close();
		return adminList;
	}

	public String checkAdminCredentials(Admin admin) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SQLQuery query = session.createSQLQuery("select 1 from Admin where email='" + admin.getEmail()
				+ "' and password = '" + admin.getPassword() + "'");
		if (query.uniqueResult() != null) {
			return "success";
		} else {
			return "failure";
		}

	}

}
